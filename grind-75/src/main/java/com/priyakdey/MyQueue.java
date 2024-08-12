package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class MyQueue {

    // Implement a first in first out (FIFO) queue using only two stacks. The implemented queue
    // should support all the functions of a normal queue (push, peek, pop, and empty).
    //
    // Implement the MyQueue class:
    // - void push(int x) Pushes element x to the back of the queue.
    // - int pop() Removes the element from the front of the queue and returns it.
    // - int peek() Returns the element at the front of the queue.
    // - boolean empty() Returns true if the queue is empty, false otherwise.
    //
    // Notes:
    // - You must use only standard operations of a stack, which means only push to top, peek/pop
    // from top, size, and is empty operations are valid.
    // - Depending on your language, the stack may not be supported natively. You may simulate a
    // stack using a list or deque (double-ended queue) as long as you use only a stack's
    // standard operations.

    private final Deque<Integer> stack;
    private final Deque<Integer> swapper;

    public MyQueue() {
        this.stack = new ArrayDeque<>();
        this.swapper = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            swapper.push(stack.pop());
        }

        stack.push(x);

        while (!swapper.isEmpty()) {
            stack.push(swapper.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
