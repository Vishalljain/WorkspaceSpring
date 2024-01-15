/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcelLogFileProcessing;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.nio.file.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class LogAnalyzerWithMail {

  public static void main(String[] args) throws MessagingException {
        try {
            String logFolderPath = "C:\\Users\\IXL1KOR\\Documents\\logs";
            String excelFilePath = "C:\\Users\\IXL1KOR\\Documents\\logs\\a.xlsx";
            String toEmail = "IXL1KOR@bosch.com";
            String subject = "Deadlock Errors Report";
            String attachmentPath = "C:\\Users\\IXL1KOR\\Documents\\logs\\a.xlsx";

            
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("DeadLockErrors");
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Date");
            headerRow.createCell(1).setCellValue("LineNumber");
            headerRow.createCell(2).setCellValue("Error");
            
            
            // Process log files
            Files.list(Paths.get(logFolderPath))
                    .filter(Files::isRegularFile)
                    .forEach(logFile -> {
                        processLogFile(logFile, sheet);
            });
            
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(excelFilePath);
                workbook.write(fos);
               
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                
            }
            finally{
                try {
                    sendEmailWithAttachment(toEmail, subject, attachmentPath);
                    workbook.close();
                } catch (IOException ex) {
                   System.out.println(ex.getMessage());
                }
            }
            
            System.out.println("Files processed successfully");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            
        }
    }

 
    private static void processLogFile(Path logFilePath, Sheet sheet) {
        try (BufferedReader reader = Files.newBufferedReader(logFilePath)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Deadlock")) {
                    String date = extractDate(line);
                    int lineNumber = extractLineNumber(line);
                    String errorMessage = extractErrorMessage(line);

                    Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                    row.createCell(0).setCellValue(date);
                    row.createCell(1).setCellValue(lineNumber);
                    row.createCell(2).setCellValue(errorMessage);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
       
    }

    private static String extractDate(String logLine) {
        // Example: Extract date from a log line (assuming the date is in a specific format)
        return logLine.substring(0, 19);
    }

    private static int extractLineNumber(String logLine) {
        // Example: Extract line number from a log line (assuming the line number is after "line ")
        int startIndex = logLine.indexOf("line ") + 5;
        int endIndex = logLine.indexOf(".", startIndex);
        return Integer.parseInt(logLine.substring(startIndex, endIndex).trim());
    }

    private static String extractErrorMessage(String logLine) {
        // Example: Extract error message from a log line (assuming the error message is after "Error: ")
        int startIndex = logLine.indexOf("Error: ") + 7;
        return logLine.substring(startIndex).trim();
    }

   private static void sendEmailWithAttachment(String toEmail, String subject, String attachmentPath) throws MessagingException {
        // Replace these properties with your Outlook email server configuration
        String host = "smtp-mail.outlook.com";
        String username = "IXL1KOR@bosch.com";
        String password = "E/opBAbymvd3";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please find the attached deadlock errors report.");

            // Create the multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attachment part
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentPath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("Deadlock_Errors_Report.xlsx");
            multipart.addBodyPart(messageBodyPart);

            // Set the multipart content to the message
            message.setContent(multipart);

            // Send the message
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}