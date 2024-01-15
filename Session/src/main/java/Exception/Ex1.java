/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
public class Ex1 {
    public static void main(String[] args) throws InvalidException {
        hello(10);
    }

    private static void hello(int a) throws InvalidException {
       if(a==10)
           throw new InvalidException("Invalid data");
       else{
           System.out.println("yes");
       }
    
}
}
