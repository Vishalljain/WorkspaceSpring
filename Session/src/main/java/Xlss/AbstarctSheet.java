/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Xlss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openide.util.Exceptions;

/**
 *
 * @author IXL1KOR
 */
public abstract  class AbstarctSheet {
    private String name;
    private Workbook workbook;
    private Sheet sheet;
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }
    
    /**
     *
     * @param name
     * @param workBookPath
     * @throws IOException
     */
    public  AbstarctSheet(String name, String workBookPath) throws IOException {
        this.name=name;
        FileInputStream fileInputStream = new FileInputStream(workBookPath);
        this.workbook=WorkbookFactory.create(fileInputStream);
        this.sheet=workbook.getSheet(name);
        if(this.sheet==null){
            throw new IllegalArgumentException("Sheet with name  "+ name +" not found in the workbook");
        }
    }
    
    protected String getStringCellValue(Row row, String ColumnName){
        int columIndex = getColumnIndex(ColumnName);
        Cell cell = row.getCell(columIndex,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        return cell.getStringCellValue();
        
    }
    
    protected int getNumericCellValue(Row row, String ColumnName){
        int columIndex = getColumnIndex(ColumnName);
        Cell cell = row.getCell(columIndex,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        return (int) cell.getNumericCellValue();
        
    }

    private int getColumnIndex(String ColumnName) {
        Row headerRow = sheet.getRow(0);
        for(int i=0; i<headerRow.getLastCellNum();i++){
            Cell cell = headerRow.getCell(i);
            if(cell.getStringCellValue().equals(ColumnName)){
                return i;
            }
        }
        throw new IllegalArgumentException("Column with name "+ ColumnName +" is not found in the sheet name "+ sheet.getSheetName());
        
        
    }
    
    
    public abstract List<Person> readData();
    
    public void CloseWorkBook(){
        try{
            if(workbook!=null){
                workbook.close();
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
