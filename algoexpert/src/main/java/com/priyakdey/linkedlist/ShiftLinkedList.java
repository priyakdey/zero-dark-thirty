package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 * @since 14-07-2024
 */
public class ShiftLinkedList {

    // Write a function that takes in the head of a Singly Linked List and an integer k, shifts
    // the list in place (i.e., doesn't create a brand new list) by k positions, and returns its
    // new head.
    //
    // Shifting a Linked List means moving its nodes forward or backward and wrapping them around
    // the list where appropriate. For example, shifting a Linked List forward by one position
    // would make its tail become the new head of the linked list.
    //
    // Whether nodes are moved forward or backward is determined by whether k is positive or
    // negative.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.
    //
    // You can assume that the input Linked List will always have at least one node; in other
    // words, the head will never be None / null.

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = length(head);
        k = k % length;
        if (k == 0) return head;

        k = k < 0 ? -k : length - k;
        return shift(head, k);
    }

    private static LinkedList shift(LinkedList head, int k) {
        LinkedList prev = null, curr = head;
        LinkedList tail = tail(head);

        while (k > 0) {
            prev = curr;
            curr = curr.next;
            k--;
        }

        prev.next = null;
        tail.next = head;
        return curr;
    }

    private static LinkedList tail(LinkedList head) {
        LinkedList tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }

    private static int length(LinkedList head) {
        LinkedList curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        return length;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

}
