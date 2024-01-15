/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mockito;

/**
 *
 * @author IXL1KOR
 */
public class CalculatorService {
    
    private final Calculator calculator;
    
    public CalculatorService(Calculator calculator){
        this.calculator = calculator;
    }
    
    public int calculateSum(int a , int b){
        System.out.println("----");
        return calculator.add(a, b);
    }
    
    public int calculateDifference(int a , int b){
        return calculator.subtract(a, b);
    }
}
