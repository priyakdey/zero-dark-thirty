package com.priyakdey.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MinStack {
    // https://leetcode.com/problems/min-stack/description/

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
