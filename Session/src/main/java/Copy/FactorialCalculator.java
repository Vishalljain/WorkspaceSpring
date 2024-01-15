/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Copy;

/**
 *
 * @author IXL1KOR
 */
public class FactorialCalculator {

    public static void main(String[] args) {
        int number = 5;
        int result = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }

    static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            // Bug: The recursive call should be calculateFactorial(n - 1), not calculateFactorial(n)
            return n * calculateFactorial(n-1);
            //5 * 4 * 3 * 2 * 1 
        }
    }
}
