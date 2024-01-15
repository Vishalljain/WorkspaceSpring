/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xlss;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author IXL1KOR
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MySheet mySheet = new MySheet("data", "C:\\Users\\IXL1KOR\\Pictures\\Camera Roll\\persons.xlsx");
        List<Person> readData = mySheet.readData();
        mySheet.setPersons(readData);
        for(Person person : readData){
           System.out.println(person);
       }
        mySheet.CloseWorkBook();
        
    }
}
