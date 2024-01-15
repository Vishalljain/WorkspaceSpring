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

public class Stream1 {

    public static void main(String[] args) {
        int[][] data = new int[][] { { 1, 2, 2 }, { 1,1,1 } };

        int result = processArray(data);

        System.out.println("Final Result: " + result);
    }

    public static int processArray(int[][] data) {
        int sum = Arrays.stream(data)
                .map(entry -> {
                    int m1 = entry[0];
                    int m2 = entry[1];
                    int expected = entry[2];

                    // First return statement
                    return m1 * m2 * expected;
                })
                .reduce(0, Integer::sum); // Stream operation (e.g., summing the values)

        // Second return statement
        return sum;
    }
}

/*
Here's a conceptual representation of the computation:

map Operation (for each entry in the data array):

Entry 1: 1 * 2 * 2 = 4
Entry 2: 5 * 3 * 15 = 225
Entry 3: 121 * 4 * 484 = 232448
Stream of Multiplication Results:

Stream: [4, 225, 232448]
reduce Operation:

Initial accumulator value: 0
Add each element to the accumulator using Integer::sum
Result: 4 + 225 + 232448 = 232677

*/

