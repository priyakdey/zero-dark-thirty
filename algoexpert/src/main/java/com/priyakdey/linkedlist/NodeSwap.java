package com.priyakdey.linkedlist;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class NodeSwap {

    // Write a function that takes in the head of a Singly Linked List, swaps every pair of
    // adjacent nodes in place (i.e., doesn't create a brand new list), and returns its new head.
    // If the input Linked List has an odd number of nodes, its final node should remain the same.
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.
    // You can assume that the input Linked List will always have at least one node; in other
    // words, the head will never be None / null

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList nodeSwap(LinkedList head) {
        Objects.requireNonNull(head);
        if (head.next == null) return head;

        LinkedList dummyHead = new LinkedList(0);
        dummyHead.next = head;

        LinkedList attachTo = dummyHead;
        LinkedList curr = head;

        while (curr != null && curr.next != null) {
            LinkedList next = curr.next;
            LinkedList nextCurr = next.next;

            next.next = curr;

            attachTo.next = next;
            curr.next = nextCurr;

            attachTo = curr;
            curr = nextCurr;
        }

        return dummyHead.next;
    }

}
