package com.example.demo.first;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

@Service
public class ExcelReaderService {

    public void readExcelAndWriteToFile(String excelFilePath, String textFilePath) throws IOException {
        FileInputStream excelFile = new FileInputStream(excelFilePath);
        Workbook workbook =  new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        
        try (FileOutputStream textFile = new FileOutputStream(textFilePath)) {
            for (Row row : sheet) {
                StringBuilder line = new StringBuilder();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    line.append(cell.toString()).append("\t"); // Assuming tab-separated
                }

                line.append("\n");
                textFile.write(line.toString().getBytes());
            }
        }

        excelFile.close();
    }
}

