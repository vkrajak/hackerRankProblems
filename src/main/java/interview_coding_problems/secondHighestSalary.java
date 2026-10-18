package interview_coding_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class secondHighestSalary {

    public static void main(String[] args){
        List<Integer> salary =  Arrays.asList(34, 56, 23,99, 24, 43, 21);
        System.out.println("Second Highest salary is: "+result(salary));
    }


    /**
     * Find the second-Highest salary/number in the given List Using the stream APi
     * distinct() - remove the duplicate value
     * sorted(Comparator.reverseOrder()) - sort the list in reverse order
     * skip(1) - skip the Highest salary
     * findFirst() - grab the next element
     * return null if it doesn't exist
     * */
    private static Integer result(List<Integer> salary){
        return salary.stream()                     //
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
}
