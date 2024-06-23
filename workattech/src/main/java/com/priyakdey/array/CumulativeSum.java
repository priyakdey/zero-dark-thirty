package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 23-06-2024
 */
public class CumulativeSum {

    // The cumulative sum of an array at index i is defined as the sum of all
    // elements of the array from index 0 to index i.

    int[] getCumulativeSum(int[] arr) {
        Objects.requireNonNull(arr);

        int length = arr.length;
        int[] cumulativeSumArr = new int[length];

        int cumulativeSum = 0;
        for (int i = 0; i < length; i++) {
            cumulativeSum += arr[i];
            cumulativeSumArr[i] = cumulativeSum;
        }

        return cumulativeSumArr;
    }

}
