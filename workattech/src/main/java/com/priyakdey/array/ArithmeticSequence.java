package com.priyakdey.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class ArithmeticSequence {

    // An Arithmetic progression (AP) or arithmetic sequence is a sequence of numbers such that
    // the difference between the consecutive terms is constant. For instance, the sequence
    // 5, 7, 9, 11, 13, 15, . . . is an arithmetic progression with a common difference of 2.
    //
    // Given an unsorted array, find if it can be reordered to form an arithmetic sequence.

    boolean isArithmeticSequence(int[] arr) {
        Objects.requireNonNull(arr);

        int length = arr.length;
        if (length <= 2) return true;

        Arrays.sort(arr);

        int diff = arr[1] - arr[0];
        for (int i = 2; i < length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

}
