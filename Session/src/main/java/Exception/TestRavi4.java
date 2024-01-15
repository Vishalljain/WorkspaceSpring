/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import org.openide.util.Exceptions;

/**
 *
 * @author IXL1KOR
 */
public class TestRavi4 {
    public static void methodA() {
        try{
            throw new Exception();
            
    }   catch (Exception ex) {
            System.out.println("Exception1");
        }finally{
            System.out.println("Finally");
        }
    
}
    public static void main(String[] args) {
      
            methodA();
        
        System.out.println("Finished");
    }
}

