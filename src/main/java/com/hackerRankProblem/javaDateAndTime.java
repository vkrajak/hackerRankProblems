package com.hackerRankProblem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class javaDateAndTime {


    /**
     * Problem: Java Date and Time (HackerRank)
     * Given a date (month, day, year), determine the day of the week.
     * Example:
     * Input:
     * 08 05 2015
     * Output:
     * WEDNESDAY
     * Time Complexity : O(1)
     * Space Complexity: O(1)
     * Author: Your Name
     */

        public static void main(String[] args) {

            // Scanner object to read user input
            Scanner scanner = new Scanner(System.in);

            // Read month, day, and year
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int year = scanner.nextInt();

            // Print the day of the week
            System.out.println(findDay(month, day, year));

            scanner.close();
        }

        /**
         * Returns the day of the week for the given date.
         *
         * @param month Month (1 - 12)
         * @param day   Day (1 - 31)
         * @param year  Year
         * @return Day of the week in uppercase
         */
        public static String findDay(int month, int day, int year) {

            /*
             * Step 1:
             * Create a LocalDate object.
             *
             * LocalDate is part of Java 8's modern Date-Time API.
             *
             * Syntax:
             * LocalDate.of(year, month, day)
             */
            LocalDate date = LocalDate.of(year, month, day);

            /*
             * Step 2:
             * Get the day of the week.
             *
             * Example:
             * WEDNESDAY
             * MONDAY
             * SUNDAY
             */
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            /*
             * Step 3:
             * Convert the DayOfWeek enum to String.
             *
             * Output format required by HackerRank:
             * UPPERCASE
             */
            return dayOfWeek.toString();
        }
}
