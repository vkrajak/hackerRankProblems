package com.hackerRankProblem;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class topKFrequentCharactersUsingJavaStreams {

    /**
     * Problem: Top K Frequent Characters Using Java Streams
     *
     * Given a string, count the frequency of each character,
     * sort them by frequency, and print the top K most frequent
     * characters along with their frequency and first occurrence index.
     *
     * Example:
     * Input:
     * abbacbddddddddddbbaac
     *
     * Output:
     * c,2,4
     * a,4,0
     * b,5,1
     * d,10,6
     *
     * Time Complexity : O(n + k log k)
     * Space Complexity: O(k)
     *
     * where
     * n = length of string
     * k = number of distinct characters
     *
     * Author: Your Name
     */

        public static void main(String[] args) {

            // Input String
            String s = "abbacbddddddddddbbaac";

            /*
             * Step 1:
             * Convert the string into a stream of characters.
             *
             * chars() returns an IntStream because
             * every character is represented by its Unicode value.
             */
            s.chars()

                    /*
                     * Step 2:
                     * Convert each integer into a Character object.
                     */
                    .mapToObj(ch -> (char) ch)

                    /*
                     * Step 3:
                     * Group identical characters together
                     * and count their occurrences.
                     *
                     * Example:
                     *
                     * {
                     *   a=4,
                     *   b=5,
                     *   c=2,
                     *   d=10
                     * }
                     */
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    ))

                    /*
                     * Step 4:
                     * Convert the Map into a Set of entries.
                     */
                    .entrySet()

                    /*
                     * Step 5:
                     * Create a stream of Map entries.
                     */
                    .stream()

                    /*
                     * Step 6:
                     * Sort entries by frequency
                     * in ascending order.
                     */
                    .sorted(Comparator.comparing(Map.Entry::getValue))

                    /*
                     * Step 7:
                     * Keep only the Top 4 most frequent characters.
                     *
                     * Formula:
                     *
                     * distinctCharacters - topK
                     */
                    .skip(s.chars().distinct().count() - 4)

                    /*
                     * Step 8:
                     * Print
                     * Character,
                     * Frequency,
                     * First Occurrence Index
                     */
                    .forEach(entry ->
                            System.out.println(
                                    entry.getKey() + ", "
                                            + entry.getValue() + ", "
                                            + s.indexOf(entry.getKey())
                            ));
        }
}
