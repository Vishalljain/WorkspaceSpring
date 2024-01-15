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
public class TestRavi3 {
    public static void methodA() throws Exception{
        try{
            throw new Exception();
            
    }finally{
            System.out.println("Finally");
        }
    
}
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception ex) {
            System.out.println("Exception");
        }
        System.out.println("Finished");
    }
}

