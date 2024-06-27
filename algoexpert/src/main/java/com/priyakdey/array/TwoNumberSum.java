package com.priyakdey.array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class TwoNumberSum {

    // Write a function that takes in a non-empty array of distinct integers and an integer
    // representing a target sum. If any two numbers in the input array sum up to the target sum,
    // the function should return them in an array, in any order. If no two numbers sum up to the
    // target sum, the function should return an empty array.
    // Note that the target sum has to be obtained by summing two different integers in the array;
    // you can't add a single integer to itself in order to obtain the target sum.
    // You can assume that there will be at most one pair of numbers summing up to the target sum.

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Objects.requireNonNull(array);
        int length = array.length;

        if (length <= 1) {
            return new int[]{};
        }

        Set<Integer> visited = new HashSet<>();

        for (int element : array) {
            int compliment = targetSum - element;
            if (visited.contains(compliment)) {
                return new int[]{compliment, element};
            }
            visited.add(element);
        }

        return new int[]{};
    }

}
