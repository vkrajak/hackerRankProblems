package com.hackerRankProblem;

import java.util.Scanner;

public class javaValidUsernameRegularExpression {

    /**
     * Problem: Java Valid Username Regular Expression (HackerRank)
     *
     * Validate whether a username satisfies the following rules:
     *
     * 1. The first character must be an English alphabet letter.
     * 2. Remaining characters may contain:
     *      - Letters
     *      - Digits
     *      - Underscore (_)
     * 3. Length must be between 8 and 30 characters.
     *
     * Example:
     *
     * Input:
     * Julia
     * Samantha_21
     * 1Samantha
     *
     * Output:
     * Invalid
     * Valid
     * Invalid
     *
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     *
     * Author: Your Name
     */

    /**
     * Regular Expression
     * <p>
     * ^             -> Beginning of the string
     * [A-Za-z]      -> First character must be a letter
     * \\w           -> Letters, digits, or underscore
     * {7,29}        -> Next 7 to 29 characters
     * $             -> End of the string
     * <p>
     * Total length:
     * 1 + (7 to 29) = 8 to 30 characters
     */
    private static final String USERNAME_REGEX = "^[A-Za-z]\\w{7,29}$";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfUsers = Integer.parseInt(scanner.nextLine());

        while (numberOfUsers-- > 0) {

            String username = scanner.nextLine();

            if (username.matches(USERNAME_REGEX)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }

        scanner.close();
    }
}
