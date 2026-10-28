package com.hackerRankProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. Understand the problem -
 * You have given an array of n integer. Your task is to find the number of contiguous sub arrays whose sum is negative
 * A sub array is a contiguous part of an array containing one or more elements
 * <p>
 * 2. use nested loop -
 * The outer loop selects the starting index (i), while the inner loop selects the ending index (j) for each sub array.
 * <p>
 * 3. Calculate the running sum -
 * Initialize sum = 0 for every new starting index. Add each element a[i] to the running sum as the inner loop progresses.
 * <p>
 * 4. count negative sum -
 * Whenever sum < 0, increment the count variable. After checking all possible aub arrays, print final count.
 * <p>
 * 5. Analyze complexity
 * The time complexity is O(n^2) because we use nested loops. The space complexity is O(n) because we store the input array.
 */

public class javaSubArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        String[] input = br.readLine().trim().split("\\s+");

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];

                if (sum < 0) {
                    count++;
                }
            }
        }
        System.out.println("array: " + count);
    }
}
