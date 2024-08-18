package com.priyakdey.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    // https://leetcode.com/problems/implement-stack-using-queues/

    private final Deque<Integer> queue;
    private final Deque<Integer> swapper;

    public MyStack() {
        this.queue = new ArrayDeque<>();
        this.swapper = new ArrayDeque<>();
    }

    public void push(int x) {
        this.queue.offer(x);
    }

    public int pop() {
        while (queue.size() > 1) {
            swapper.offer(queue.poll());
        }
        int root = queue.poll();
        while (!swapper.isEmpty()) {
            queue.offer(swapper.poll());
        }

        return root;
    }


    public int top() {
        while (queue.size() > 1) {
            swapper.offer(queue.poll());
        }
        int root = queue.poll();
        swapper.offer(root);
        while (!swapper.isEmpty()) {
            queue.offer(swapper.poll());
        }

        return root;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}