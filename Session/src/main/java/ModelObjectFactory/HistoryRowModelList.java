/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelObjectFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IXL1KOR
 */
public class HistoryRowModelList implements IHistoryRowModelList{
    
    List<String> list = new ArrayList(10);
    
    @Override
    public void addHistoryRow(String data) {
         System.out.println("Added to history row: " + data);
    }
    
    public void addDataInList(){
        list.add("Vishal");
        list.add("Hello");
    }
    
}
