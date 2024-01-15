/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
public class ExceptionHandlingExample2 {

    public static int calculate() {
        try {
            // Attempting to divide by zero, which will result in an ArithmeticException
            System.out.println("in try");
            return 2 / 0;
        } catch (ArithmeticException e) {
            // Catch block is executed when an ArithmeticException occurs
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
            return 1;
        } finally {
            System.out.println("Finally block is executed");
            return 2 / 0;
            // Finally block is always executed, even if an exception is caught
           
            
        }
    }

    public static void main(String[] args) {
        int result=1;
        try{
         result = ExceptionHandlingExample2.calculate();
        }catch(Exception e){
            System.out.println("Exception Handled");
        }
        System.out.println("Result: " + result);
    }
}

/*
When you run this code, you'll see that the exception is caught, the finally block is executed, 
and the final result printed is 0. The return statement in the finally block
overrides the return statement in the catch block.
*/