/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lambda;

import java.util.Arrays;

/**
 *
 * @author IXL1KOR
 */
public class Array1 {
    
    
    
    public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5};
    System.out.println(numbers);
    
    String result = Arrays.toString(numbers);
    System.out.println(result);
    
        int[] doubleElements = doubleElements(numbers);
        System.out.println(Arrays.toString(doubleElements));
        
    
    

       
        
    }

    private static int[] doubleElements(int[] array) {
         int[] doubledArray = new int[array.length]; // Line 30
        for (int i = 0; i < array.length; i++) { // Line 31
            doubledArray[i] = array[i] * 2; // Line 32
        }
        return doubledArray; // Line 33
    }
    }
    

