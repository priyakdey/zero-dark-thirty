package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 23-06-2024
 */
public class MergeTwoSortedArrays {

    // Given two sorted arrays A and B, find the merged sorted array C by merging A and B.

    int[] mergeSortedArrays(int[] A, int[] B) {
        if (A == null || A.length == 0) return B;
        if (B == null || B.length == 0) return A;

        int length1 = A.length, length2 = B.length;
        int i = 0, j = 0;

        int length = length1 + length2;
        int k = 0;
        int[] mergedArr = new int[length];

        while (i < length1 && j < length2) {
            if (A[i] <= B[j]) {
                mergedArr[k++] = A[i++];
            } else {
                mergedArr[k++] = B[j++];
            }
        }

        while (i < length1) {
            mergedArr[k++] = A[i++];
        }

        while (j < length2) {
            mergedArr[k++] = B[j++];
        }

        return mergedArr;
    }

}
