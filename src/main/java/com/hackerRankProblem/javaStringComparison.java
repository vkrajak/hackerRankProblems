package com.hackerRankProblem;

import java.util.Scanner;

public class javaStringComparison {

    /**
     * Read two strings, print their combined length,
     * determine if the first string is lexicographically greater than the second,
     * and display both strings with their first letter capitalized.
     * 
     * Problem: Java Strings Introduction (HackerRank)
     * Given two strings:
     * 1. Print the sum of their lengths.
     * 2. Print "Yes" if the first string is lexicographically greater than the second,
     *    otherwise print "No".
     * 3. Capitalize the first letter of each string and print them separated by a space.
     * Example:
     * Input:
     * hello
     * java
     * Output:
     * 9
     * No
     * Hello Java
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     * Author: Your Name
     */

        public static void main(String[] args) {

            // Scanner object to read user input
            Scanner scanner = new Scanner(System.in);

            // Read two strings
            String first = scanner.next();
            String second = scanner.next();

            /*
             * Step 1:
             * Print the total length of both strings.
             */
            System.out.println(first.length() + second.length());

            /*
             * Step 2:
             * Compare the strings lexicographically.
             *
             * compareTo() returns:
             *
             * > 0  : first string is greater
             * < 0  : second string is greater
             * = 0  : both strings are equal
             */
            if (first.compareTo(second) > 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            /*
             * Step 3:
             * Capitalize the first letter of each string.
             */
            String formattedFirst =
                    first.substring(0, 1).toUpperCase()
                            + first.substring(1).toLowerCase();

            String formattedSecond =
                    second.substring(0, 1).toUpperCase()
                            + second.substring(1).toLowerCase();

            System.out.println(formattedFirst + " " + formattedSecond);

            scanner.close();
        }
}
