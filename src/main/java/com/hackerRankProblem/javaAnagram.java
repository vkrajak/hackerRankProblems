package com.hackerRankProblem;

import java.util.Scanner;

public class javaAnagram {

    /**
     * Problem: Java Anagrams (HackerRank)
     * Two strings are said to be anagrams if they contain the same characters
     * with the same frequency, regardless of their order.
     * Examples:
     *  listen  -> silent      (Anagrams)
     *  anagram -> margana     (Anagrams)
     *  hello   -> world       (Not Anagrams)
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     * Author: Your Name
     */

        public static void main(String[] args) {

            // Scanner object to read user input
            Scanner sc = new Scanner(System.in);

            // Read two strings
            String first = sc.next();
            String second = sc.next();

            // Check whether they are anagrams
            if (isAnagram(first, second)) {
                System.out.println("Anagrams");
            } else {
                System.out.println("Not Anagrams");
            }

            sc.close();
        }

        /**
         * Checks whether two strings are anagrams.
         * @param first  First input string
         * @param second Second input string
         * @return true if both strings are anagrams, otherwise false
         */
        public static boolean isAnagram(String first, String second) {

            /*
             * Step 1:
             * If the lengths are different, they can never be anagrams.
             */
            if (first.length() != second.length()) {
                return false;
            }

            /*
             * Step 2:
             * Convert both strings to lowercase.
             * This makes the comparison case-insensitive.
             * Example:
             * Listen
             * Silent
             * becomes
             * listen
             * silent
             */
            first = first.toLowerCase();
            second = second.toLowerCase();

            /*
             * Step 3:
             * Create an array of size 26.
             * Why 26?
             * There are 26 lowercase English letters:
             * a b c d e ... z
             * Each index represents one character.
             * Index:
             * a -> 0
             * b -> 1
             * c -> 2
             * ...
             * z -> 25
             */
            int[] frequency = new int[26];

            /*
             * Step 4:
             * Count characters from the first string.
             * Subtract characters from the second string.
             * Example:
             * first  = anagram
             * second = margana
             * For every character:
             * frequency['a']++
             * frequency['m']--
             */
            for (int i = 0; i < first.length(); i++) {

                /*
                 * char - 'a'
                 *
                 * 'a' - 'a' = 0
                 * 'b' - 'a' = 1
                 * 'c' - 'a' = 2
                 * ...
                 * 'z' - 'a' = 25
                 */

                frequency[first.charAt(i) - 'a']++;
                frequency[second.charAt(i) - 'a']--;
            }

            /*
             * Step 5:
             * If every element is zero,
             * both strings have exactly the same character frequencies.
             * Otherwise, they are not anagrams.
             */
            for (int count : frequency) {

                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
}
