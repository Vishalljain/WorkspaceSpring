package com.example.demo.second;


import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelReaderServiceUser {

    public List<User> readExcel(String excelFilePath) throws IOException {
        List<User> users = new ArrayList<>();
        FileInputStream excelFile = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(excelFile);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Iterator<Cell> cellIterator = row.cellIterator();
            User user = new User();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if (cell.getColumnIndex() == 0) {
                    user.setFunctionName(cell.toString());
                } else if (cell.getColumnIndex() == 1) {
                    user.setUse(cell.toString());
                }
                else {
                	user.setValue(cell.toString());
                }
            }

            users.add(user);
        }

        excelFile.close();
        return users;
    }
}
