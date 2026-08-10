package com.hackerRankProblem;

import java.util.Scanner;

public class javaSumOfPrimeNumbers {

    /**
     * Problem: Sum of All Prime Numbers Till N
     * A prime number is a number greater than 1 that has exactly
     * two factors: 1 and itself.
     * Given an integer N, calculate the sum of all prime numbers
     * from 2 to N (inclusive).
     * Example:
     * Input:
     * 10
     * Output:
     * 17
     * Explanation:
     * Prime Numbers:
     * 2 + 3 + 5 + 7 = 17
     * Time Complexity : O(N√N)
     * Space Complexity: O(1)
     * Author: Your Name
     */

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();

            long sum = 0;

            /*
             * Check every number from 2 to N.
             */
            for (int number = 2; number <= n; number++) {

                if (isPrime(number)) {
                    sum += number;
                }
            }

            System.out.println(sum);

            scanner.close();
        }

        /**
         * Checks whether a number is prime.
         *
         * @param number Number to be checked
         * @return true if prime, otherwise false
         */
        public static boolean isPrime(int number) {

            /*
             * Numbers less than 2 are not prime.
             */
            if (number < 2) {
                return false;
            }

            /*
             * Check divisibility only till √number.
             */
            for (int i = 2; i * i <= number; i++) {

                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
}
