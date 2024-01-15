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

public class StreamRepresentationExample {

    public static void main(String[] args) {
        int[][] data = new int[][] { { 1, 2, 2 }, { 1, 1, 1 } };

        // Create a stream of arrays
        Stream<int[]> originalStream = Arrays.stream(data);

        // Step 1: Representing the original stream of arrays
        System.out.println("Original Stream of Arrays");
        System.out.println("-------------------------");
        originalStream.map(Arrays::toString)
                      .forEach(System.out::println);

        // Create a new stream after doubling each element
        Stream<int[]> doubledStream = Arrays.stream(data);

        // Step 2: Representing the stream after doubling each element
        System.out.println("\nStream after Doubling Each Element");
        System.out.println("---------------------------------");
        doubledStream.map(entry -> Arrays.toString(doubleElements(entry)))
                      .forEach(System.out::println);
    }

    // Helper method to double each element in an array
    private static int[] doubleElements(int[] array) {
        int[] doubledArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            doubledArray[i] = array[i] * 2;
        }
        return doubledArray;
    }
}

