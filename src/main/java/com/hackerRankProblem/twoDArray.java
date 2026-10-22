package com.hackerRankProblem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 1. Import the required classes. Use java.io.* for BufferedReader, InputStreamReader, and IOException,
 * and java.util.* for collections.
 * 2. Create the BufferedReader object. Use new BufferedReader(new InputStreamReader(System.in))
 * to read input from the console efficiently.
 * 3. Read the 6 × 6 input. Read six lines using readLine(), split each line into numbers, convert them to integers,
 * and store them in a List<List<Integer>>.
 * 4. Create a 2D integer array. Declare int[][] a = new int[6][6] to store the input in an easily accessible format.
 * 5. Copy the input into the array. Use nested loops with i < 6 and j < 6. Assign each value from arr.get(i).get(j) to a[i][j].
 * 6. Initialize the maximum sum. Set max = Integer.MIN_VALUE so that negative hourglass sums are handled correctly.
 * 7. Traverse all valid hourglass positions. Use nested loops with i < 4 and j < 4,
 * because an hourglass occupies three rows and three columns.
 * 8. Calculate each hourglass sum. Add the three top-row values, the center value of the middle row,
 * and the three bottom-row values — exactly seven elements.
 * 9. Compare the current sum with the maximum. If sum > max, update max = sum.
 * 10. Print the result. After checking all 16 possible hourglasses, print max using System.out.println(max).
 * 11. State the complexity. For the fixed 6 × 6 input, time and auxiliary space are both \(O(1)\).
 * For a generalized \(n \times n\) grid, the time is \(O(n^2)\), and the space is \(O(n^2)\) when storing a copy of the grid.
 */

public class twoDArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                new RuntimeException(ex);
            }
        });
        bufferedReader.close();

        int max = Integer.MIN_VALUE;
        int[][] a = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = arr.get(i).get(j);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1] + a[i + 2][j] + a[i + 2][j + 1] + a[i + 2][j + 2];

                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
