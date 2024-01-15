/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
public class ExceptionHandlingExample1 {

    public static int calculate() {
        try {
            // Attempting to divide by zero, which will result in an ArithmeticException
            return 2 / 0;
        } catch (ArithmeticException e) {
            // Catch block is executed when an ArithmeticException occurs
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
            return 1;
        } finally {
            // Finally block is always executed, even if an exception is caught
            System.out.println("Finally block is executed");
            return 0;
        }
    }

    public static void main(String[] args) {
        int result = ExceptionHandlingExample1.calculate();
        System.out.println("Result: " + result);
    }
}

/*
When you run this code, you'll see that the exception is caught, the finally block is executed, 
and the final result printed is 0. The return statement in the finally block
overrides the return statement in the catch block.
*/