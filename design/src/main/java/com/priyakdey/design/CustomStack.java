package com.priyakdey.design;

public class CustomStack {
    // https://leetcode.com/problems/design-a-stack-with-increment-operation/

    private final int[] stack;
    private final int capacity;
    private int cursor;

    public CustomStack(int maxSize) {
        this.capacity = maxSize;
        this.stack = new int[maxSize];
        this.cursor = 0;
    }
    
    public void push(int x) {
        if (cursor == capacity) {
            return;
        }

        this.stack[cursor] = x;
        this.cursor++;
    }
    
    public int pop() {
        if (cursor == 0) {
            return -1;
        }

        return this.stack[--this.cursor];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, cursor); i++) {
            stack[i] += val;
        }
    }
}