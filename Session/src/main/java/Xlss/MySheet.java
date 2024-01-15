/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xlss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author IXL1KOR
 */
public class MySheet extends AbstarctSheet{

    public MySheet(String name,String WorkBookPath) throws IOException {
        super(name,WorkBookPath);
    }

    
    @Override
    public List<Person> readData() {
       List<Person> listOfPerson = new ArrayList<>();
       for(int rowIndex = 1 ; rowIndex<=super.getSheet().getLastRowNum(); rowIndex++){
           Row row = super.getSheet().getRow(rowIndex);
           String personName = super.getStringCellValue(row, "personName");
           String personCompany = super.getStringCellValue(row, "personCompany");
           String personCity = super.getStringCellValue(row, "personCity");
           int personId = super.getNumericCellValue(row, "personId");
           
           Person person = new Person();
           person.setPersonName(personName);
           person.setPersonCompany(personCompany);
           person.setPersonCity(personCity);
           person.setPersonId(personId);
           
           listOfPerson.add(person);
       }
       
      
        return listOfPerson;
    }
    
}
