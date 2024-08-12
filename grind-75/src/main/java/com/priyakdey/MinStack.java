package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 * @since 10-07-2024
 */
public class MinStack {

    // Design a stack that supports push, pop, top, and retrieving the minimum element in
    // constant time.
    //
    // Implement the MinStack class:
    // - MinStack() initializes the stack object.
    // - void push(int val) pushes the element val onto the stack.
    // - void pop() removes the element on the top of the stack.
    // - int top() gets the top element of the stack.
    // - int getMin() retrieves the minimum element in the stack.
    // You must implement a solution with O(1) time complexity for each function.

    private final Deque<Pair> stack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int min = val;
        if (!stack.isEmpty()) {
            min = Math.min(min, getMin());
        }

        this.stack.push(new Pair(val, min));
    }

    public void pop() {
        safeAccess();
        stack.pop();
    }

    public int top() {
        safeAccess();
        return stack.peek().value;
    }

    public int getMin() {
        safeAccess();
        return stack.peek().min;
    }

    private void safeAccess() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }
    }

    private record Pair(int value, int min) {
    }
}
