package com.example.demo.second;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DataControllerWithUser {

    @Autowired
    private ExcelReaderServiceUser excelReaderService;

    @GetMapping("/getDataUser")
    public ResponseEntity<String> getData(
            @RequestParam("excelFilePath") String excelFilePath,
            @RequestParam("textFilePath") String textFilePath) {
        try {
        	System.out.println("ExcelFilePath :"+excelFilePath);
        	System.out.println("TextFilePath :"+textFilePath);
            List<User> users = excelReaderService.readExcel(excelFilePath);

            try (FileOutputStream textFile = new FileOutputStream(textFilePath)) {
                for (User user : users) {
                    String line = user.getFunctionName() + "\t" + user.getUse()+"\t"+ user.getValue() + "\n";
                    textFile.write(line.getBytes());
                }
            }

            return ResponseEntity.ok("Data successfully extracted and written to " + textFilePath);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/data")
    public String showDataExtractionPage() {
    	System.out.println("Inside");
        return "demo"; // Return the name of the HTML file (without the extension)
    }
}
