package com.hackerRankProblem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array s of n real number strings, sort them in descending order based on their actual numerical values.
 * The original string representation (e.g., trailing zeros, leading zeros, or lacking a leading zero like .12)
 * must be preserved in the final output.
 */

/** To solve this problem, we cannot simply use standard string sorting because alphabetical sorting fails for numbers
 *  (e.g., "10" would incorrectly come before "2"). We also shouldn't parse them into primitive double or float types
 *  because we could lose decimal precision or fail to handle extremely large numbers.

 My approach is to use a custom comparator with Java's BigDecimal class:

 1. Preserve the Formatting: We keep the elements inside the array as String objects so that we don't alter their original look.
 2. Custom Comparison: We pass a custom lambda comparator to Arrays.sort(). For every two strings compared, we temporarily parse
 them into BigDecimal objects.
 3. Descending Order: Instead of comparing the first string to the second (a.compareTo(b)), we reverse the logic and compare
 the second to the first (b.compareTo(a)). This inherently forces the sorting algorithm to order them from highest value to lowest
 value."

 3. Complexity Analysis

 Time Complexity: \(\mathcal{O}(n \log n \cdot m)\)

 • Sorting Component: Java’s Arrays.sort() uses Timsort for objects, which takes \(\mathcal{O}(n \log n)\) comparisons.
 • String Parsing Component: In every comparison step, we construct two BigDecimal objects from strings of length \(m\).
 Converting a string to a BigDecimal takes linear time relative to the number of digits, \(\mathcal{O}(m)\).
 • Therefore, the exact time complexity is \(\mathcal{O}(n \log n \cdot m)\),
 where \(n\) is the number of elements and \(m\) is the maximum number of digits in a string.

 Space Complexity: \(\mathcal{O}(n)\)

 • We are modifying the array in-place, so we don't use a separate array data structure.
 • However, Timsort requires a temporary workspace memory of \(\mathcal{O}(n)\) to merge elements during the sorting process.
 • The garbage collector dynamically frees the temporary BigDecimal instances created during the comparisons,
 keeping auxiliary operational memory to \(\mathcal{O}(1)\) at any given moment.

 4. Key Edge Cases to Mention to the Interviewer

 Impress your interviewer by proactively mentioning these edge cases:
 • Equivalent Values with Different Formats: .12 and 0.12 evaluate to the exact same numerical value.
 Their relative order will be preserved because Timsort is a stable sorting algorithm.
 • Leading/Trailing Zeros: 02.34 and 2.340 are accurately parsed by BigDecimal without causing throwing number format exceptions.
 • Arbitrary Precision: If a string contains a 100-digit decimal, BigDecimal handles it flawlessly without overlapping or
 overflowing like a primitive double would.

 example input - 9
 -100
 50
 0
 56.6
 90
 0.12
 .12
 02.34
 000.000
 */
public class bigDecimalSortingDescending {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, 0, n, (s1, s2) -> {
            BigDecimal a = new BigDecimal(s1);
            BigDecimal b = new BigDecimal(s2);
            return b.compareTo(a);
        });

        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }

    }
}
