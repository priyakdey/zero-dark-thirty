package com.priyakdey.design;

class FrontMiddleBackQueue {

    private Node head;
    private Node tail;

    private int size;

    public FrontMiddleBackQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void pushFront(int val) {
        Node node = new Node(val);
        if (size == 0) {
            init(node);
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void pushMiddle(int val) {
        Node node = new Node(val);
        if (size == 0) {
            init(node);
        } else {
            Node mid = findMid();
            Node prev = mid.prev;
            if (prev == null) {
                head.prev = node;
                node.next = head;
                head = node;
            } else {
                prev.next = node;
                node.next = mid;
                node.prev = prev;
                mid.prev = node;
            }
        }
        size++;
    }

    public void pushBack(int val) {
        Node node = new Node(val);
        if (size == 0) {
            init(node);
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }

        Node node = head;
        if (size == 1) {
            deallocate();
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return node.val;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }

        Node node = findMid();
        if (size == 1) {
            deallocate();
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        size--;
        return node.val;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }

        Node node = tail;
        if (size == 1) {
            deallocate();
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return node.val;
    }

    private Node findMid() {
        Node curr = head.next;
        Node mid = head;

        while (curr != null && curr.next != null) {
            mid = curr;
            curr = curr.next;
        }

        return mid;
    }

    private void init(Node node) {
        head = node;
        tail = node;
    }

    private void deallocate() {
        head = null;
        tail = null;
    }

    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }
}