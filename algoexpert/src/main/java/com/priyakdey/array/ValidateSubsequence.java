package com.priyakdey.array;

import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class ValidateSubsequence {

    // Given two non-empty arrays of integers, write a function that determines whether the second
    // array is a subsequence of the first one.
    // A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array
    // but that are in the same order as they appear in the array. For instance, the numbers [1, 3, 4]
    // form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4]. Note that a single
    // number in an array and the array itself are both valid subsequences of the array.

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (array == null || array.isEmpty() || sequence == null || sequence.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        int i = 0, j = 0;

        while (i < array.size() && j < sequence.size()) {
            if (Objects.equals(array.get(i), sequence.get(j))) {
                j++;
            }
            i++;
        }

        return j == sequence.size();
    }
}
