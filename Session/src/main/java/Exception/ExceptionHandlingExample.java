/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author IXL1KOR
 */
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class ExceptionHandlingExample {

    // Approach 1: Declare the exception using 'throws'
    public void methodWithThrows() throws MyException {
        // Some code that may throw MyException
        throw new MyException("Exception thrown in methodWithThrows");
    }

    // Approach 2: Handle the exception using 'try-catch'
    public void methodWithTryCatch() {
        try {
            // Some code that may throw MyException
            throw new MyException("Exception thrown in methodWithTryCatch");
        } catch (MyException e) {
            // Handle the exception, log it, or take appropriate action
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExceptionHandlingExample example = new ExceptionHandlingExample();

        // Example of handling the exception with 'throws'
        try {
            example.methodWithThrows();
        } catch (MyException e) {
            // Handle the exception, log it, or take appropriate action
            e.printStackTrace();
        }

        // Example of handling the exception with 'try-catch'
        example.methodWithTryCatch();
    }
}
