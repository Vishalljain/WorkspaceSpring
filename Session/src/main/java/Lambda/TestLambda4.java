/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lambda;

/**
 *
 * @author IXL1KOR
 */
// Calculator interface
interface Calculator {
    int calculate(int x, int y);
}

// Lambda expression example
class LambdaExample {
    public static void main(String[] args) {
        // Lambda expression
        Calculator add = (x, y) -> x + y;
        int resultAdd = add.calculate(5, 3);
        System.out.println("Lambda result (addition): " + resultAdd);
        
        Calculator multiply = (x, y) -> x * y;
        int resultMultiply = multiply.calculate(4, 6);
        System.out.println("Lambda result (multiplication): " + resultMultiply);
    }
}

// Anonymous class example
class AnonymousExample {
    public static void main(String[] args) {
        // Anonymous class
        Calculator subtract = new Calculator() {
            @Override
            public int calculate(int x, int y) {
                return x - y;
            }
        };
        int resultSubtract = subtract.calculate(8, 2);
        System.out.println("Anonymous result (subtraction): " + resultSubtract);
    }
}

// Normal class example
class NormalClassExample {
    public static void main(String[] args) {
        // Normal class
        Calculator divide = new DivideCalculator();
        int resultDivide = divide.calculate(10, 2);
        System.out.println("Normal class result (division): " + resultDivide);
    }
}

// Normal class implementation
class DivideCalculator implements Calculator {
    @Override
    public int calculate(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return x / y;
    }
}

