/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcelLogFileProcessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openide.util.Exceptions;

/**
 *
 * @author IXL1KOR
 */
public class LogProcessor {

    public static void main(String[] args) {
        try {
            String logFolderPath = "C:\\Users\\IXL1KOR\\Documents\\logs";
            String excelFilePath = "C:\\Users\\IXL1KOR\\Documents\\logs\\a.xlsx";
            
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
                try {
                    processLogFile(logFile, sheet);
                } catch (MalformedInputException ex) {
                    System.out.println(ex.getMessage()+"---");
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
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

    private static void processLogFile(Path logFile, Sheet sheet) throws IOException {
       // BufferedReader bufferedReader = Files.newBufferedReader(logFile);
        BufferedReader bufferedReader =Files.newBufferedReader(logFile, StandardCharsets.UTF_8);
        String line;
        int rowNumber = 1;
        while (null != (line = bufferedReader.readLine())) {
            if (line.contains("Deadlock ") || line.contains("deadlock ")) {
                String date = extractDate(line);
                String lineNumber = extractLineNo(line);
                String errorData = extractErrorData(line);
                Row row = sheet.createRow(sheet.getLastRowNum()+1);
                row.createCell(0).setCellValue(date);
                row.createCell(1).setCellValue(lineNumber);
                row.createCell(2).setCellValue(errorData);
            }
            rowNumber++;
        }

    }

    private static String extractDate(String line) {
        return line.substring(0, 19);
    }

    private static String extractLineNo(String line) {
        int startIndex = line.indexOf("line") + 5;
        int endIndex = line.indexOf(".");
        return line.substring(startIndex, endIndex);
        
        /* OR
        int startIndex = line.indexOf("line") + 5;
        int endIndex = line.indexOf(".", startIndex);
        line.substring(startIndex, endIndex);
        */
    }

    private static String extractErrorData(String line) {
        int startIndexOf = line.indexOf("Error") + 7;
        int lastIndexOf = line.lastIndexOf(".");
        return line.substring(startIndexOf, lastIndexOf);
    }

}
