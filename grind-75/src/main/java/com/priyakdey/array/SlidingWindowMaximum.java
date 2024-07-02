package com.priyakdey.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 * @since 03-07-2024
 */
public class SlidingWindowMaximum {

    // You are given an array of integers nums, there is a sliding window of size k which is
    // moving from the very left of the array to the very right. You can only see the k numbers
    // in the window. Each time the sliding window moves right by one position.
    // Return the max sliding window.

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("invalid argument");
        }

        Deque<Integer> deque = new ArrayDeque<>(k);
        int length = nums.length;
        int[] maxElementInWindow = new int[length - k + 1];

        for (int i = 0; i < k; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && num > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(num);
        }

        maxElementInWindow[0] = deque.peekFirst();

        int cursor = 1;

        for (int i = k; i < length; i++) {
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }

            int num = nums[i];
            while (!deque.isEmpty() && num > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(num);

            maxElementInWindow[cursor++] = deque.peekFirst();
        }

        return maxElementInWindow;
    }

}
