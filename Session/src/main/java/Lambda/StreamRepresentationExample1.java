/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lambda;

/**
 *
 * @author IXL1KOR
 */
import java.util.Arrays;
import java.util.stream.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamRepresentationExample1 {

    public static void main(String[] args) {
        int[][] data = new int[][] { { 1, 2, 2 }, { 1, 1, 1 } };

        // Create a stream of arrays
        Stream<int[]> originalStream = Arrays.stream(data); // Line 10

        // Step 1: Representing the original stream of arrays
        System.out.println("Original Stream of Arrays"); // Line 13
        System.out.println("-------------------------"); // Line 14
        originalStream.map(Arrays::toString) // Line 15
                      .forEach(System.out::println); // Line 16

        // Create a new stream after doubling each element
        Stream<int[]> doubledStream = Arrays.stream(data); // Line 19

        // Step 2: Representing the stream after doubling each element
        System.out.println("\nStream after Doubling Each Element"); // Line 22
        System.out.println("---------------------------------"); // Line 23
        doubledStream.map(entry -> {
            // Corrected: doubleElements will be called here
            System.out.println(Arrays.toString(entry));
            int[] doubledArray = doubleElements(entry); // Line 25
            return Arrays.toString(doubledArray);
        })
        .forEach(System.out::println); // Line 26
    }

    // Helper method to double each element in an array
    private static int[] doubleElements(int[] array) { // Line 29
        int[] doubledArray = new int[array.length]; // Line 30
        for (int i = 0; i < array.length; i++) { // Line 31
            doubledArray[i] = array[i] * 2; // Line 32
        }
        return doubledArray; // Line 33
    }
}
