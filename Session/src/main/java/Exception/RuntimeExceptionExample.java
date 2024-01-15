/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
public class RuntimeExceptionExample {

    static void methodWithRuntimeException() {
        // Unchecked exception (ArithmeticException) - no need to declare or catch
        int result = 10 / 0;
    }

    public static void main(String[] args) {
       
            // Calling a method that throws an unchecked exception
            methodWithRuntimeException();
       
        // Rest of the program continues to execute
        System.out.println("Program continues after handling the exception.");
    }
}

