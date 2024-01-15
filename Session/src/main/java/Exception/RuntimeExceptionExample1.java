/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
public class RuntimeExceptionExample1 {

    static void methodWithRuntimeException() {
        // Unchecked exception (ArithmeticException) - no need to declare or catch
        int result = 10 / 0;
    }

    public static void main(String[] args) {
        try {
            // Calling a method that throws an unchecked exception
            methodWithRuntimeException();
        } catch (ArithmeticException e) {
            // Catching the runtime exception for handling or logging
            System.out.println("Caught runtime exception: " + e.getMessage());
        }

        // Rest of the program continues to execute
        System.out.println("Program continues after handling the exception.");
    }
}

