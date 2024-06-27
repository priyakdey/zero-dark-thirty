package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 28-06-2024
 */
public class SubarraySort {

    // Write a function that takes in an array of at least two integers and that returns an array
    // of the starting and ending indices of the smallest subarray in the input array that needs
    // to be sorted in place in order for the entire input array to be sorted (in ascending order).
    // If the input array is already sorted, the function should return [-1, -1].

    public static int[] subarraySort(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length <= 1) return new int[]{-1, -1};
        if (length == 2) return array[0] > array[1] ? new int[]{0, 1} : new int[]{-1, -1};

        int maxTill = array[0];
        int rightMostIndex = -1;

        for (int i = 1; i < length; i++) {
            if (array[i] < maxTill) {
                rightMostIndex = i;
            } else {
                maxTill = array[i];
            }
        }

        int minTill = array[length - 1];
        int leftMostIndex = -1;

        for (int i = length - 2; i >= 0; i--) {
            if (array[i] > minTill) {
                leftMostIndex = i;
            } else {
                minTill = array[i];
            }
        }

        return new int[]{leftMostIndex, rightMostIndex};

    }

}
