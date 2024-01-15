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
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRepresentationExample2 {

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

        // Step 2: Representing the stream after doubling each element and reducing to sum
        System.out.println("\nStream after Doubling and Reducing to Sum"); // Line 22
        System.out.println("----------------------------------------"); // Line 23
        doubledStream.map(entry -> {
            // Visualizing the doubling operation
            System.out.println("Doubling Operation"); // Extra line for visualization
            System.out.println(Arrays.toString(entry) + " -> " + Arrays.toString(doubleElements(entry))); // Extra line for visualization
            return doubleElements(entry);
        })
        .map(StreamRepresentationExample2::sumArray) // Map to the sum
        .forEach(System.out::println); // Visualizing the forEach operation
        
        
        
         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
       
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();System.out.println(sum);
    }

    // Helper method to double each element in an array
    private static int[] doubleElements(int[] array) { // Line 29
        int[] doubledArray = new int[array.length]; // Line 30
        for (int i = 0; i < array.length; i++) { // Line 31
            doubledArray[i] = array[i] * 2; // Line 32
        }
        return doubledArray; // Line 33
    }

    // Helper method to calculate the sum of an array
    private static int sumArray(int[] array) { // Line 36
        return Arrays.stream(array).sum(); // Line 37
    }
    
    
}


/*
Sum Operation Requires IntStream:
int sum = numbers.stream().mapToInt(Integer::intValue).sum();System.out.println(sum);
    
The sum operation is part of the IntStream interface in Java. It directly operates on primitive int values.
List Returns a Stream<Integer>:

When you call stream() on a List<Integer>, it returns a Stream<Integer>. This is because a List can contain elements of any type, and streams in Java work with objects.
mapToInt Converts Stream<Integer> to IntStream:

To apply the sum operation, you need an IntStream. Therefore, you use the mapToInt operation to convert the Stream<Integer> to an IntStream.
mapToInt(Integer::intValue) is a method reference that converts each Integer in the stream to its corresponding int value. It essentially "unboxes" the Integer objects to primitive int values.
Applying the Sum Operation:

Once you have an IntStream, you can directly apply the sum operation to calculate the sum of the primitive int values.
In summary, the mapToInt(Integer::intValue) part is a necessary conversion step to adapt the stream of boxed Integer objects to a stream of primitive int values, allowing you to use the sum operation. It's a common pattern when working with streams and primitive types in Java to improve performance and avoid unnecessary object overhead.
*/