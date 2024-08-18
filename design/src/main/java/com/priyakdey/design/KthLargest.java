package com.priyakdey.design;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/

    private final PriorityQueue<Integer> minHeap;
    private final int capacity;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        minHeap = new PriorityQueue<>(capacity);
        Arrays.stream(nums).forEach(this::add);
    }
    
    public int add(int val) {
        if (minHeap.size() == capacity) {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
        } else {
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}
