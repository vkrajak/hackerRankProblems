package interview_coding_problems;

import java.util.*;

/**
 * Given an array of String words, return the words that can bt typed using letters from only one row of the American QWERTY keyboard
 * Constraints - 1<= words.length <= 20, 1<=words[i].length <= 20,words[i] contains English letters, according to the visible portion
 * of the statement
 * The comparison is case-insensitive, but the output should preserve the original spelling of each word.
 */

/**
 * Time and space complexity
 Let (n) be the number of words and (m) be the maximum length of a word.
 Time complexity: (O(nm))
 Building the keyboard map takes (O(1)) time because the keyboard contains only 26 letters.
 Each word is checked character by character, taking at most (O(m)) time.
 Checking all (n) words takes (O(nm)) time.
 Auxiliary space complexity: (O(1)) excluding the input and output.
 The keyboard map always contains 26 entries, regardless of input size.
 The output list is not counted as auxiliary space here; it can store up to (n) words. Including the output,
 the space complexity is (O(n)).
 */

/**
 * Q1. Why use Character as the key and Integer as the value?
 * Because each keyboard character maps to one integer row number. Java's Map<Character, Integer> represents that relationship.
 * <p>
 * Q2. Why do we convert the word to lowercase?
 * Because uppercase and lowercase letters should be treated identically. The map stores lowercase characters,
 * so converting the input simplifies the comparisons.
 * <p>
 * Q3. Why start the inner loop at index 1?
 * The character at index 0 already determines the reference row. We only need to check the remaining characters.
 * <p>
 * Q4. Why use break?
 * As soon as a character belongs to a different row, the word is invalid. Checking more characters cannot change that result.
 * <p>
 * Q5. Can we solve it without a HashMap?
 * Yes. We can use three strings representing the keyboard rows and check membership using contains().
 * The HashMap approach makes the character-to-row relationship explicit and provides efficient lookups.
 * <p>
 * Q6. Why return result.toArray(new String[0])?
 * Because the required return type is String[], while result is an ArrayList. This converts the list into an array of strings.
 */

public class americanKeyboardStringSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // I create a Scanner object to read input from the console.
        int n = sc.nextInt(); // I read the number of words the user wants to enter.
        String[] words = new String[n]; // I create a string array of size n to store all the input words.


        for (int i = 0; i < n; i++) {
            words[i] = sc.next(); // I use a loop to read each word and store it in the array.
        }

        String[] result = findWords(words); //I call the findWords() method and pass the array. This method checks which words belong to a single keyboard row.
        System.out.println(Arrays.toString(result)); //I print the resulting array in a readable format, such as [Alaska, Dad].
        sc.close(); //I close the scanner after reading the input.
    }

    private static String[] findWords(String[] words) {
        /**I create a HashMap in which:
         The key is a character - like q a x r
         The value is the keyboard row number - like q-0, a-1, x-2

         Why use a HashMap?
         It allows me to find the keyboard row for any character efficiently, typically in (O(1)) time.
         */
        Map<Character, Integer> row = new HashMap<>();
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"}; //I store the three keyboard rows in an array. The array index represents the row number: 0, 1, or 2.

        /**I convert the current row into a character array and visit each character individually.
         For example, for the first row, the characters are q, w, e, r, and so on.
         */
        for (int i = 0; i < keyboard.length; i++) {
            for (char ch : keyboard[i].toCharArray()) {
                /**I insert each character and its corresponding row number into the HashMap.
                 After these loops, every lowercase English letter has a row number assigned to it.*/
                row.put(ch, i);
            }
        }
        /**I create an ArrayList to store words that can be typed using only one keyboard row.
         I use a list because I do not know in advance how many words will satisfy the condition.
         */
        List<String> result = new ArrayList<>();

        for (String word : words) { // I examine every word in the input array one by one.
            String lower = word.toLowerCase(); //I convert the word to lowercase so uppercase and lowercase letters are treated equally.
            int firstRow = row.get(lower.charAt(0)); // I still keep the original word so I can return it with its original capitalization.

            /**I find the keyboard row of the first character and store it in firstRow.
             For "dad", the first character is d, which belongs to row 1. Therefore, firstRow = 1.
             This row becomes the reference for checking the remaining characters.
             */
            boolean valid = true; // Initially, I assume that the word is valid. If any character belongs to a different row, I change this value to false.

            for (int i = 0; i < lower.length(); i++) { // I iterate through the remaining characters, starting from index 1, because the first character has already established the reference row.
                if (row.get(lower.charAt(i)) != firstRow) {
                    /**For every character, I retrieve its row number from the HashMap and compare it with firstRow.
                     If the row numbers differ, the word uses more than one keyboard row.

                     I mark the word as invalid and immediately stop checking it.
                     The break avoids unnecessary comparisons because one character from a different row is enough to reject the word.
                     */
                    valid = false;
                    break;
                }
            }
            // After checking all the characters,
            // I add the original word to the result list only if every character belongs to the same row.
            if (valid) {
                result.add(word);
            }
        }
        // The method must return a String[], but the result is stored in a List<String>.
        // I convert the list into a string array and return it.
        return result.toArray(new String[0]);
    }


}
