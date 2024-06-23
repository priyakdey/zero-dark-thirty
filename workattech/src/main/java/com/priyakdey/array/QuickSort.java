package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 23-06-2024
 */
public class QuickSort {

    // Given an array, sort it using quicksort.

    void quickSort(int[] arr) {
        Objects.requireNonNull(arr);

        int length = arr.length;
        if (length <= 1) return;

        sort(arr, 0, length - 1);
    }

    void sort(int[] arr, int start, int end) {
        if (start >= end) return;

        int partitionIndex = partitionArr(arr, start, end);
        sort(arr, start, partitionIndex - 1);
        sort(arr, partitionIndex + 1, end);
    }

    private int partitionArr(int[] arr, int start, int end) {
        int pivotElement = arr[end];

        int curr = start;
        int swapAt = start;

        while (curr < end) {
            if (arr[curr] <= pivotElement) {
                swap(arr, curr, swapAt);
                swapAt++;
            }
            curr++;
        }

        int pivotIndex = swapAt;
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
