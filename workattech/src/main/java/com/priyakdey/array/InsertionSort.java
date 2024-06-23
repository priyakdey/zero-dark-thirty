package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 23-06-2024
 */
public class InsertionSort {

    // Given an array, sort it using insertion sort.

    void insertionSort(int[] arr) {
        Objects.requireNonNull(arr);
        int length = arr.length;
        if (length <= 1) return;

        for (int i = 1; i < length; i++) {
            int element = arr[i];
            int index = findInsertionPosition(arr, element, 0, i - 1);
            if (index != -1) {
                System.arraycopy(arr, index, arr, index + 1, i - 1 - index + 1);
                arr[index] = element;
            }
        }

    }

    private int findInsertionPosition(int[] arr, int element, int left, int right) {
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (element <= arr[mid]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
