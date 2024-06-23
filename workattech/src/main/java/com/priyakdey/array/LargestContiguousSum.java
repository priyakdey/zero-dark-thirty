package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class LargestContiguousSum {

    // A subarray is a part of an array including one or more contiguous/adjacent elements.
    // If we find the sum of the elements of any subarray then that sum will be known as a
    // contiguous sum. You are given an array of numbers (could be -ve as well).
    // You need to find the largest contiguous sum from the array.

    int largestContiguousSum(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("invalid argument");

        int length = arr.length;
        if (length == 1) return arr[0];

        int maxSum = arr[0];
        int currMaxSum = arr[0];

        for (int i = 1; i < length; i++) {
            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum);
        }

        return maxSum;
    }

}
