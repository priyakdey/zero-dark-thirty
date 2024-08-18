package com.priyakdey.design;

public class MyHashMap {
    // https://leetcode.com/problems/design-hashmap/

    private static final int CAPACITY = 0x10;

    private final Node[] table;

    public MyHashMap() {
        this.table = new Node[CAPACITY];
    }

    public void put(int key, int value) {
        Node node = findNodeWithKey(key);
        if (node == null) {
            putVal(key, value);
        } else {
            node.value = value;
        }
    }

    public int get(int key) {
        Node node = findNodeWithKey(key);
        return node != null ? node.value : -1;
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

    private void putVal(int key, int value) {
        int index = key % CAPACITY;
        Node node = new Node(key, value);
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
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}