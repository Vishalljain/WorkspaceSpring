/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
public class NullPoint {
    public static void main(String[] args) {
       dataCheck();
       parameterCheck(null);
       parameterCheckAsString(null);
       parameterCheckAsInteger(null);
        
        
    }

    private static void dataCheck() {
       String s1 = null;
       String s2 = "_value";
       String output = s1+s2;
      
       System.out.println(output);
       
    }

    private static void parameterCheck(Object object) {
        System.out.println("Hey I am :" + object);
    }

    private static void parameterCheckAsString(String str) {
       System.out.println("Hey I am :" + str);
    }

    private static void parameterCheckAsInteger(Integer int1) {
         System.out.println("Hey I am :" + int1);
    }
}
