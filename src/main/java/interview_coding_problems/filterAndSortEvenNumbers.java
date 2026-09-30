package interview_coding_problems;
import java.util.*;
import java.util.stream.Collectors;

public class filterAndSortEvenNumbers {

    /** Stream in java *
     *Java 8 stream API is used to process collections of data in a simple and functional way.
     * It allows us to perform operation like filtering, sorting, mapping, and collecting data
     * without writing traditional loops.
     * Stream does nt store data: it processes data from a source like a List or Set.
    * */

    public static List<Integer> filterAndSortEvenNumbers(List<Integer> numbers){
        return numbers.stream().filter(num -> num %2 ==0)
                .sorted().collect(Collectors.toList());
    }

    /** stream(): coverts the list into stream
     * filter(num -> num % 2 ==0): keeps only even numbers
     * sorted(): sorts the numbers into the ascending order
     * collect(Collectors.toList()): converts the stream back to list
     * */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 2, 9, 4, 1, 8, 6, 3);
        List<Integer> result = filterAndSortEvenNumbers(numbers);
        System.out.println("Input: " + numbers);
        System.out.println("Output: " + result);
    }
}
