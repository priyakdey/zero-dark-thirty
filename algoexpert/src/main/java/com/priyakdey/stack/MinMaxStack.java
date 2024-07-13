package com.priyakdey.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 * @since 12-07-2024
 */
public class MinMaxStack {

    // Write a MinMaxStack class for a Min Max Stack. The class should support:
    //
    // Pushing and popping values on and off the stack.
    // Peeking at the value at the top of the stack.
    // Getting both the minimum and the maximum values in the stack at any given point in time.
    // All class methods, when considered independently, should run in constant time and with
    // constant space.

    private final Deque<Tuple> stack = new ArrayDeque<>();

    public int peek() {
        return safeTop().value;
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("underflow");
        }
        return stack.pop().value;
    }

    public void push(Integer number) {
        int max = number;
        int min = number;
        if (!stack.isEmpty()) {
            max = Math.max(number, getMax());
            min = Math.min(number, getMin());
        }
        stack.push(new Tuple(number, max, min));
    }

    public int getMin() {
        return safeTop().min;
    }

    public int getMax() {
        return safeTop().max;
    }

    private Tuple safeTop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("underflow");
        }
        return stack.peek();
    }

    private record Tuple(int value, int max, int min) {
    }

}
