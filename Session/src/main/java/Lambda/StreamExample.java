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
import java.util.List;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        int[][] data = new int[][] { { 1, 2, 2 }, { 1, 1, 1 } };

        processArray(data);
    }

    public static void processArray(int[][] data) {
        Stream<int[]> stream = Arrays.stream(data);

        // Print each element in the stream
        stream.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}


