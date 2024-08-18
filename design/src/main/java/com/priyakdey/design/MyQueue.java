package com.priyakdey.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MyQueue {

    // https://leetcode.com/problems/implement-queue-using-stacks/description/

    private final Deque<Integer> stack;
    private final Deque<Integer> swapper;

    public MyQueue() {
        this.stack = new ArrayDeque<>();
        this.swapper = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        swap(stack, swapper);
        int root = swapper.pop();
        swap(swapper, stack);
        return root;
    }

    public int peek() {
        swap(stack, swapper);
        int root = swapper.peek();
        swap(swapper, stack);
        return root;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    private void swap(Deque<Integer> stack1, Deque<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

}
