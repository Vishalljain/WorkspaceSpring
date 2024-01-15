package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/excel")
//@CrossOrigin(origins = "*") // Allow requests from any origin (for development, restrict in production)
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/process")
    public ResponseEntity<Object> processExcelWithJson(@RequestBody Map<String, String> excelInfo) {
        System.out.println("Inside the post method");
        System.out.println(excelInfo.get("textFileName"));//{textFileName=C:\\Users\\IXL1KOR\\Documents\\ECU.txt, excelFileName=C:\\Users\\IXL1KOR\\Documents\\ECU.xlsx}
    	String excelFilePath = excelInfo.get("excelFileName");
        String textFilePath = excelInfo.get("textFileName");

        try {
            excelService.readExcelAndWriteToFile(excelFilePath,textFilePath);
            System.out.println("SuccessFull");
            Map<String, String> response = new HashMap<>();
            response.put("message", "Excel processing successful.");
            return ResponseEntity.ok(response);
            //return ResponseEntity.ok("Excel processing successful.");
        } catch (Exception e) {
        	System.out.println("Pass");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing Excel: " + e.getMessage());
        }
    }
    
    @PostMapping("/dataFile")
    public ResponseEntity<String> processExcelWithoutJSON1(@RequestBody Map<String, String> excelInfo) {
        System.out.println("Inside the post method");
        System.out.println(excelInfo.get("textFileName"));//{textFileName=C:\\Users\\IXL1KOR\\Documents\\ECU.txt, excelFileName=C:\\Users\\IXL1KOR\\Documents\\ECU.xlsx}
    	String excelFilePath = excelInfo.get("excelFileName");
        String textFilePath = excelInfo.get("textFileName");

        try {
            excelService.readExcelAndWriteToFile(excelFilePath,textFilePath);
            String responseMessage = "Excel processing successful.";
            return ResponseEntity.ok()
                    //.contentType(MediaType.TEXT_PLAIN)
                    .body(responseMessage);

        } catch (Exception e) {
        	System.out.println("Pass");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing Excel: " + e.getMessage());
        }
    }
    
    
    @PostMapping("/dataFile1")
    public String processExcelWithoutJSON(@RequestBody Map<String, String> excelInfo) {
        System.out.println("Inside the post method");
        System.out.println(excelInfo.get("textFileName"));//{textFileName=C:\\Users\\IXL1KOR\\Documents\\ECU.txt, excelFileName=C:\\Users\\IXL1KOR\\Documents\\ECU.xlsx}
    	String excelFilePath = excelInfo.get("excelFileName");
        String textFilePath = excelInfo.get("textFileName");

        try {
            excelService.readExcelAndWriteToFile(excelFilePath,textFilePath);
            System.out.println("inside this");
            String responseMessage = "Excel processing successful.";
            System.out.println("here");
            return responseMessage;

        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	System.out.println("Pass");
           
        }
        System.out.println("here1");
		return textFilePath;
    }
    
    
    @GetMapping("/wel")
    public String sayHello() {
    	System.out.println("inside");
    	return "Hello Boschlers!!!!!";
    }
    
}
