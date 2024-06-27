package com.priyakdey.array;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class MonotonicArray {

    // Write a function that takes in an array of integers and returns a boolean representing
    // whether the array is monotonic.
    // An array is said to be monotonic if its elements, from left to right, are entirely
    // non-increasing or entirely non-decreasing.Non-increasing elements aren't necessarily
    // exclusively decreasing; they simply don't increase. Similarly, non-decreasing elements
    // aren't necessarily exclusively increasing; they simply don't decrease.
    // Note that empty arrays and arrays of one element are monotonic.

    public static boolean isMonotonic(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length <= 2) {
            return true;
        }

        BiPredicate<Integer, Integer> nonDecreasingPredicate = (x, y) -> x <= y;
        BiPredicate<Integer, Integer> nonIncreasingPredicate = (x, y) -> x >= y;

        int curr = 1;
        while (curr < length && array[curr] == array[curr - 1]) {
            curr++;
        }

        if (curr == length) {
            // all elements are equal
            return true;
        }

        BiPredicate<Integer, Integer> predicate = array[curr] > array[curr - 1] ?
                nonDecreasingPredicate : nonIncreasingPredicate;

        while (curr < length) {
            if (!predicate.test(array[curr - 1], array[curr])) {
                return false;
            }
            curr++;
        }

        return true;
    }
}
