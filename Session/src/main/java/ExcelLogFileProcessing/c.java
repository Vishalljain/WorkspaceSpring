/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcelLogFileProcessing;

/**
 *
 * @author IXL1KOR
 */
public class c {
    public static void main(String[] args) {
        String str = "2023-01-01 12:00:00 Deadlock detected at line 42. Error: Unable to acquire lock.";
        
        String substring = str.substring(41, 48);System.out.println(substring);
        
        int startIndex = str.indexOf("line") + 5;
        System.out.println(startIndex);//46
        int endIndex = str.indexOf(".", startIndex);
        System.out.println(str.indexOf("."));//48
        System.out.println(str.substring(46, 48));
        
        System.out.println(str.substring(startIndex));
        String substring1 = str.substring(startIndex, endIndex);System.out.println(substring1);
        
        
        int name = str.indexOf("Error")+7;
        int lastIndexOf = str.lastIndexOf(".");System.out.println(str.subSequence(name, lastIndexOf));
    }
}
