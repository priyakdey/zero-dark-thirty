package com.priyakdey.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 23-06-2024
 */
public class EvenNumberOfDigits {

    // Given an array of integers, find the elements which have an even number of digits.
    // The order of the returned elements should be the same as the order of the initial array.

    List<Integer> getEvenDigitNumbers(int[] arr) {
        Objects.requireNonNull(arr);

        List<Integer> result = new ArrayList<>();

        for (int element : arr) {
            if (getNumberOfDigits(element) % 2 == 0) {
                result.add(element);
            }
        }

        return result;
    }

    private int getNumberOfDigits(int n) {
        if (n == 0) return 1;

        int digits = 0;
        while (n != 0) {
            digits += 1;
            n = n / 10;
        }

        return digits;
    }
}
