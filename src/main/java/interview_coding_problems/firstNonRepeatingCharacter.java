package interview_coding_problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class firstNonRepeatingCharacter {

    /** There are three standard ways to solve this in Java:
     * 1.  the optimal LinkedHashMap approach - time and space complexity O(n), O(k) K:number of unique characters
     * 2. a fast character-frequency array approach - Most optimal, time and space complexity O(n), O(1)
     * 3. a modern Java 8+ Streams approach - Functional Approach, time and space complexity
     */
    public static void main(String[] agrs){
        String input = "geeksforgeeks";
        System.out.println("First Non Repeating Character is: " + getFirstNonRepeating(input));
    }

//    private static Character getFirstNonRepeating(String str){
//        if(str == null || str.isEmpty()){
//            return null;
//        }
//
//        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
//
//        // Step 1: Build the frequency map
//        for(char ch : str.toCharArray()){
//            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
//        }
//
//        // Step 2: Find the first key with a value of 1
//        for(Map.Entry<Character, Integer> map : charCountMap.entrySet()){
//            if(map.getValue() == 1){
//                return map.getKey();
//            }
//        }
//        return null;
//    }

//    private static char getFirstNonRepeating(String str){
//        if(str == null || str.isEmpty()){
//            return '\0';
//        }
//
//        int[] count = new int[256]; // For ASCII characters
//
//        // Step 1: Count occurrences
//        for(int i = 0; i < str.length(); i++){
//            count[str.charAt(i)]++;
//        }
//
//        for(int i = 0; i < str.length(); i++){
//            if(count[str.charAt(i)] == 1){
//                return str.charAt(i);
//            }
//        }
//        return '\0';
//    }

    private static Character getFirstNonRepeating(String str){
        if(str == null || str.isEmpty()){
            return null;
        }

        /**
         * 1. str.chars() – Converts the string into an IntStream of character values.
         * 2. .mapToObj(c -> (char) c) – Converts each integer value into a Character object.
         * 3. .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
         *    – Groups identical characters, counts their occurrences,
         *    and stores them in a LinkedHashMap to preserve their original order.
         * 4. .entrySet() – Converts the map into a set of key-value pairs, where the key is the character and the value is its count.
         * 5. .stream() – Creates a stream to process these entries.
         * 6. .filter(entry -> entry.getValue() == 1) – Keeps only characters that appear exactly once.
         * 7. .map(Map.Entry::getKey) – Extracts the character from each remaining entry.
         * 8. .findFirst() – Returns the first non-repeating character in the original order.
         * 9. .orElse(null) – Returns null if no non-repeating character exists.*/
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap :: new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
