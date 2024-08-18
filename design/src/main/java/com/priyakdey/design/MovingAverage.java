package com.priyakdey.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {
    // https://leetcode.com/problems/moving-average-from-data-stream/

    private final Deque<Integer> deque;
    private final int capacity;
    private int sum;

    public MovingAverage(int size) {
        this.deque = new ArrayDeque<>(size);
        this.capacity = size;
        this.sum = 0;
    }

    public double next(int val) {
        push(val);
        return (double) sum / deque.size();
    }

    private void push(int val) {
        if (deque.size() == capacity) {
            sum -= deque.pollFirst();
        }
        deque.offerLast(val);
        sum += val;
    }
}