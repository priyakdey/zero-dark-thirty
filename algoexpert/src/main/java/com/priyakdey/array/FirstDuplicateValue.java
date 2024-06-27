package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class FirstDuplicateValue {

    // Given an array of integers between 1 and n, inclusive, where n is the length of the array,
    // write a function that returns the first integer that appears more than once (when the
    // array is read from left to right).
    // In other words, out of all the integers that might occur more than once in the input
    // array, your function should return the one whose first duplicate value has the minimum index.
    // If no integer appears more than once, your function should return -1.
    // Note that you're allowed to mutate the input array.

    public int firstDuplicateValue(int[] array) {
        Objects.requireNonNull(array);

        for (int i = 0, length = array.length; i < length; i++) {
            int num = Math.abs(array[i]);
            int index = num - 1;
            if (array[index] < 0) {
                return num;
            }
            array[index] *= -1;
        }

        return -1;
    }

}
