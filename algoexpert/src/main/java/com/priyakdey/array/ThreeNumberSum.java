package com.priyakdey.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class ThreeNumberSum {

    // Write a function that takes in a non-empty array of distinct integers and an integer
    // representing a target sum. The function should find all triplets in the array that sum up
    // to the target sum and return a two-dimensional array of all these triplets. The numbers in
    // each triplet should be ordered in ascending order, and the triplets themselves should be
    // ordered in ascending order with respect to the numbers they hold.
    // If no three numbers sum up to the target sum, the function should return an empty array.

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0, length = array.length; i < length - 2; i++) {
            int left = i + 1, right = length - 1;
            int num = array[i];
            while (left < right) {
                int sum = num + array[left] + array[right];
                if (sum == targetSum) {
                    triplets.add(new Integer[]{num, array[left], array[right]});
                    left++;
                    right--;
                } else if (sum > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return triplets;
    }

}
