package com.priyakdey.design;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    // https://leetcode.com/problems/peeking-iterator/

    private final Iterator<Integer> iterator;
    private int next;
    private boolean hasPeeked;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.next = 0;
        this.hasPeeked = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            hasPeeked = true;
            next = iterator.next();
        }

        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasPeeked) {
            hasPeeked = false;
            return next;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}