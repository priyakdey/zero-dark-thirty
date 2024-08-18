package com.priyakdey.design;

public class MyHashSet {
    // https://leetcode.com/problems/design-hashset/

    private static final int CAPACITY = 0x10;

    private final Node[] table;

    public MyHashSet() {
        this.table = new Node[CAPACITY];
    }

    public void add(int key) {
        Node node = findNodeWithKey(key);
        if (node == null) {
            putVal(key);
        }
    }

    public void remove(int key) {
        Node node = findNodeWithKey(key);
        if (node == null) {
            return;
        }

        Node prev = null, next = null;
        if (node.prev != null) {
            prev = node.prev;
        }

        if (node.next != null) {
            next = node.next;
        }

        if (prev == null) {
            int index = key % CAPACITY;
            table[index] = next;
            if (table[index] != null) {
                table[index].prev = null;
            }
        } else if (next == null) {
            prev.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }

    public boolean contains(int key) {
        Node node = findNodeWithKey(key);
        return node != null;
    }

    private void putVal(int key) {
        int index = key % CAPACITY;
        Node node = new Node(key);
        if (table[index] == null) {
            table[index] = node;
        } else {
            Node head = table[index];
            table[index] = node;
            node.next = head;
            head.prev = node;
        }
    }

    private Node findNodeWithKey(int key) {
        int index = key % CAPACITY;
        if (table[index] == null) {
            return null;
        }

        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) {
                break;
            }
            curr = curr.next;
        }

        return curr;
    }

    private static class Node {
        int key;
        Node next;
        Node prev;

        public Node(int key) {
            this.key = key;
        }
    }

}