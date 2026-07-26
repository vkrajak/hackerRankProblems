package com.hackerRankProblem;

import java.util.Scanner;

public class javaPalindrome {

    /**
     * Problem: Java String Reverse (Palindrome)
     * A palindrome is a word, phrase, number, or sequence of characters
     * that reads the same forward and backward.
     * Examples:
     * madam   -> Palindrome
     * level   -> Palindrome
     * racecar -> Palindrome
     * hello   -> Not Palindrome
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     * Author: Your Name
     */

    public static void main(String[] args) {

        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Read the input string
        String input = scanner.next();

        // Check whether the string is a palindrome
        if (isPalindrome(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }

    /**
     * Checks whether a string is a palindrome.
     *
     * @param word Input string
     * @return true if the string is a palindrome,
     * otherwise false
     */
    public static boolean isPalindrome(String word) {

        /*
         * Step 1:
         * Initialize two pointers.
         *
         * left  -> starts from the beginning
         * right -> starts from the end
         */
        int left = 0;
        int right = word.length() - 1;

        /*
         * Step 2:
         * Compare characters from both ends.
         *
         * If any pair is different,
         * the string is not a palindrome.
         */
        while (left < right) {

            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            /*
             * Move both pointers toward the center.
             */
            left++;
            right--;
        }

        /*
         * Step 3:
         * If all characters matched,
         * the string is a palindrome.
         */
        return true;
    }
}
