package com.priyakdey.array;

import java.util.*;

/**
 * @author Priyak Dey
 * @since 27-06-2024
 */
public class FourSumNumber {

    // Write a function that takes in a non-empty array of distinct integers and an integer
    // representing a target sum. The function should find all quadruplets in the array that sum
    // up to the target sum and return a two-dimensional array of all these quadruplets in no
    // particular order.
    // If no four numbers sum up to the target sum, the function should return an empty array.

    // TODO: This can alsop be done in O(n^2) time complexity.

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Objects.requireNonNull(array);

        int length = array.length;
        if (length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(array);

        List<Integer[]> quadruplets = new ArrayList<>();

        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = array[i] + array[j] + array[left] + array[right];
                    if (sum == targetSum) {
                        quadruplets.add(new Integer[]{array[i], array[j], array[left],
                                array[right]});
                        left++;
                        right--;
                    } else if (sum > targetSum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return quadruplets;
    }

}
