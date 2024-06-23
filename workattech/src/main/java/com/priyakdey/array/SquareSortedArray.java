package com.priyakdey.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class SquareSortedArray {

    // Given an array of numbers, return an array that contains the squares of all the numbers in
    // non-decreasing order

    int[] getSquareSortedArray(int[] arr) {
        Objects.requireNonNull(arr);
        return Arrays.stream(arr).map(n -> n * n).sorted().toArray();
    }
}
