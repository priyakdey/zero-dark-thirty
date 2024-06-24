package com.priyakdey.array;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class KthLargestElement {

    // Given a list of numbers below:
    //         4, 3, 6, 4, 1
    //
    // What is the largest element in the list? → 6
    //
    // What is the 3rd largest element in the list? → 4

    int getKthLargestElement(int[] list, int k) {
        Objects.requireNonNull(list);
        if (k > list.length) {
            throw new IllegalArgumentException("invalid argument");
        }

        // implementation with min heap
        // return getKthLargestElementHeap(list, k);

        // quickselect
        return getKthLargestElementQuickSelect(list, k, 0, list.length - 1);
    }


    int getKthLargestElementHeap(int[] list, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int element : list) {
            if (minHeap.size() < k) {
                minHeap.offer(element);
            } else {
                if (element > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(element);
                }
            }
        }

        return minHeap.poll();
    }

    int getKthLargestElementQuickSelect(int[] list, int k, int left, int right) {
        int index = partitionList(list, left, right);
        if (index == k - 1) {
            return list[index];
        } else if (index > k - 1) {
            return getKthLargestElementQuickSelect(list, k, left, index - 1);
        } else {
            return getKthLargestElementQuickSelect(list, k, index + 1, right);
        }
    }

    private int partitionList(int[] list, int left, int right) {
        int pivotElement = list[right];

        int curr = left;
        int swapAt = left;

        while (curr < right) {
            if (list[curr] > pivotElement) {
                swap(list, swapAt, curr);
                swapAt++;
            }

            curr++;
        }

        int pivotIndex = swapAt;
        swap(list, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
