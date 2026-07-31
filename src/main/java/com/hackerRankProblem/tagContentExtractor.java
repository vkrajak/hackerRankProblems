package com.hackerRankProblem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tagContentExtractor {
    /**
     * Problem: Tag Content Extractor (HackerRank)
     * <p>
     * Given lines containing HTML/XML-like tags, extract and print
     * the content enclosed by matching opening and closing tags.
     * <p>
     * Rules:
     * 1. Opening and closing tags must have the same name.
     * 2. Nested tags are allowed.
     * 3. If no valid content exists, print "None".
     * <p>
     * Example:
     * <p>
     * Input:
     * <h1>Nayeem loves counseling</h1>
     * <p>
     * Output:
     * Nayeem loves counseling
     * <p>
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     * <p>
     * Author: Your Name
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        /*
         * Regex Explanation:
         *
         * <(.+)>
         *      Captures the tag name.
         *
         * ([^<]+)
         *      Captures everything except another '<'
         *      (the actual tag content).
         *
         * </\\1>
         *      Closing tag must match the opening tag.
         */
        String regex = "<(.+)>([^<]+)</\\1>";

        Pattern pattern = Pattern.compile(regex);

        while (testCases-- > 0) {

            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            boolean found = false;

            while (matcher.find()) {

                System.out.println(matcher.group(2));
                found = true;
            }

            if (!found) {
                System.out.println("None");
            }
        }

        scanner.close();
    }
}
