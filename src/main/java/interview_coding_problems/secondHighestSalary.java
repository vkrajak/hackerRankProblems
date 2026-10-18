package interview_coding_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class secondHighestSalary {

    public static void main(String[] args){
//        List<Integer> salary =  Arrays.asList(34, 56, 23,99, 24, 43, 21);
        List<Integer> salary =  List.of(133, 44, 564,100, 342, 54, 678);
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
//    private static Integer result(List<Integer> salary){
//        return salary.stream()                     //
//                .distinct()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst()
//                .orElse(null);
//    }

    private static Integer result(List<Integer> salaries){

        // Handle edge cases where there aren't enough elements
        if(salaries == null || salaries.size()<2){
            return null;
        }

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for(int salary : salaries){
            if(salary > highest){
                // The old highest becomes the second highest
                secondHighest = highest;
                highest = salary;
            } else if(salary > secondHighest && salary != highest){
                // Update second highest only if it's strictly less than highest
                // and greater than the current second highest (ignores duplicates)
                secondHighest = salary;
            }
        }
        // If secondHighest was never updated, it means all elements were identical
        return (secondHighest == Integer.MIN_VALUE) ? null : secondHighest;
    }


}
