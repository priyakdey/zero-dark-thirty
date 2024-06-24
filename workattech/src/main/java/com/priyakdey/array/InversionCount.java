package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class InversionCount {

    // The inversion count of an array denotes how far is the array from being sorted.
    // If the array is sorted, inversion count is 0. If the array is sorted in reverse order,
    // the inversion count is maximum.
    // More formally, the inversion count of an array A is the number of pairs (i, j) such
    // A[i] < A[j] and i > j.
    //         Example
    // Lets take the following array:
    //         8, 4, 1, 2
    // This array has an inversion count of 5.
    //         (8, 4), (8, 1), (8, 2), (4, 1), (4, 2)
    // Given an array A, calculate the inversion count of the array.

    int getInversionCount(int[] array) {
        Objects.requireNonNull(array);
        return getInversionCount(array, 0, array.length - 1);
    }

    int getInversionCount(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        return getInversionCount(array, left, mid) + getInversionCount(array, mid + 1, right)
               + merge(array, left, mid, mid + 1, right);
    }

    int merge(int[] array, int left1, int right1, int left2, int right2) {
        int length1 = right1 - left1 + 1;
        int length2 = right2 - left2 + 1;
        int length = length1 + length2;
        int[] mergedArr = new int[length];

        int curr1 = left1;
        int curr2 = left2;
        int curr = 0;
        int inversionCount = 0;

        while (curr1 <= right1 && curr2 <= right2) {
            if (array[curr1] <= array[curr2]) {
                mergedArr[curr++] = array[curr1++];
            } else {
                inversionCount += right1 - curr1 + 1;
                mergedArr[curr++] = array[curr2++];
            }
        }

        while (curr1 <= right1) {
            mergedArr[curr++] = array[curr1++];
        }

        while (curr2 <= right2) {
            mergedArr[curr++] = array[curr2++];
        }

        System.arraycopy(mergedArr, 0, array, left1, length);

        return inversionCount;
    }

}
