/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcelLogFileProcessing;

/**
 *
 * @author IXL1KOR
 */
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

    private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());

    public static void main(String[] args) {
        setupLogger();

        // Log some messages at different levels
        LOGGER.severe("This is a severe message.");
        LOGGER.warning("This is a warning message.");
        LOGGER.info("This is an info message.");
        LOGGER.config("This is a config message.");
    }

    private static void setupLogger() {
        try {
            // Create a FileHandler that writes log entries to a file
            FileHandler fileHandler = new FileHandler("C:\\Users\\IXL1KOR\\Desktop\\logs\\mylog.log");

            // Create a SimpleFormatter for formatting log entries
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            // Set the logging level (you can adjust this as needed)
            LOGGER.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);

            // Add the FileHandler to the Logger
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

