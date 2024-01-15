package com.example.demo.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private ExcelReaderService excelReaderService;

    @GetMapping("/getData")
    public ResponseEntity<String> getData() {
        try {
            String excelFilePath = "C:\\Users\\IXL1KOR\\Documents\\ECU.xlsx";
            String textFilePath = "C:\\Users\\IXL1KOR\\Documents\\ECU.txt";

            excelReaderService.readExcelAndWriteToFile(excelFilePath, textFilePath);
            return ResponseEntity.ok("Data successfully extracted and written to " + textFilePath);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
    
    
}
