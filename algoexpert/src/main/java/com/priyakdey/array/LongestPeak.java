package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class LongestPeak {
    // Write a function that takes in an array of integers and returns the length of the longest
    // peak in the array.
    // A peak is defined as adjacent integers in the array that are strictly increasing until
    // they reach a tip (the highest value in the peak), at which point they become strictly
    // decreasing. At least three integers are required to form a peak.
    // For example, the integers 1, 4, 10, 2 form a peak, but the integers 4, 0, 10 don't and
    // neither do the integers 1, 2, 2, 0. Similarly, the integers 1, 2, 3 don't form a peak
    // because there aren't any strictly decreasing integers after the 3.

    public static int longestPeak(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length < 3) {
            return 0;
        }
        if (length == 3) {
            return array[0] < array[1] && array[1] > array[2] ? 3: 0;
        }

        int curr = 1;
        int maxLength = 0;
        while (curr < length - 1) {
            boolean isPeak = array[curr] > array[curr - 1] && array[curr] > array[curr + 1];
            if (!isPeak) {
                curr++;
                continue;
            }

            int leftIndex = curr - 1;
            while (leftIndex > 0 && array[leftIndex] > array[leftIndex - 1]) {
                leftIndex--;
            }

            int rightIndex = curr + 1;
            while (rightIndex < length - 1 && array[rightIndex] > array[rightIndex + 1]) {
                rightIndex++;
            }

            int len = rightIndex - leftIndex + 1;
            if (len > maxLength) {
                maxLength = len;
            }

            curr = rightIndex;
        }

        return maxLength;
    }

}
