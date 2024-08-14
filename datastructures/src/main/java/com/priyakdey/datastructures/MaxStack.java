package com.priyakdey.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {

    private final Deque<Pair> stack;

    public MaxStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Pair(x, x));
        }

        int max = this.peekMax();
        stack.push(new Pair(x, Math.max(max, x)));
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }

        return stack.pop().value;
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }

        return stack.peek().value;
    }

    public int peekMax() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }

        return stack.peek().max;
    }

    public int popMax() {

    }

    private record Pair(int value, int max) {
    }

}
