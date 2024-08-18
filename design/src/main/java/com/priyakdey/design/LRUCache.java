package com.priyakdey.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // https://leetcode.com/problems/lru-cache/

    private final Map<Integer, Node> table;
    private final int capacity;

    private Node mru;
    private Node lru;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        table = HashMap.newHashMap(capacity);
    }

    public int get(int key) {
        Node node = findNode(key);
        if (node == null) {
            return -1;
        }

        makeMru(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = findNode(key);
        if (node != null) {
            node.value = value;
            makeMru(node);
        } else {
            if (size == capacity) {
                Node evictedNode = evictLru();
                table.remove(evictedNode.key);
            }
            Node newNode = addNode(key, value);
            table.put(key, newNode);
        }
    }

    private Node findNode(int key) {
        return table.getOrDefault(key, null);
    }

    private Node addNode(int key, int value) {
        Node node = new Node(key, value);
        if (size == 0) {
            mru = node;
            lru = node;
        } else {
            mru.next = node;
            node.prev = mru;
            mru = node;
        }
        size++;
        return node;
    }

    private void makeMru(Node node) {
        if (node == mru || size == 1) {
            return;
        }

        if (this.size == 0) {
            mru = node;
            lru = node;
            return;
        }

        if (node == lru) {
            lru = lru.next;
            lru.prev = null;
            mru.next = node;
            node.next = null;
            node.prev = mru;
            mru = node;
            return;
        }

        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        mru.next = node;
        node.next = null;
        node.prev = mru;
        mru = node;
    }

    private Node evictLru() {
        Node evicted = lru;
        if (size == 1) {
            mru = null;
            lru = null;
        } else if (size == 2) {
            lru = lru.next;
            lru.prev = null;
            mru = lru;
        } else {
            lru = lru.next;
            lru.prev = null;
        }
        size--;
        return evicted;
    }

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}