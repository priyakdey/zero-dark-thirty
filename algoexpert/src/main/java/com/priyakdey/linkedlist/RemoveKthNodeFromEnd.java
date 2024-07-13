package com.priyakdey.linkedlist;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 14-07-2024
 */
public class RemoveKthNodeFromEnd {

    // Write a function that takes in the head of a Singly Linked List and an integer k and
    // removes the kth node from the end of the list.
    //
    // The removal should be done in place, meaning that the original data structure should be
    // mutated (no new structure should be created).
    //
    // Furthermore, the input head of the linked list should remain the head of the linked list
    // after the removal is done, even if the head is the node that's supposed to be removed. In
    // other words, if the head is the node that's supposed to be removed, your function should
    // simply mutate its value and next pointer.
    //
    // Note that your function doesn't need to return anything.
    //
    // You can assume that the input Linked List will always have at least two nodes and, more
    // specifically, at least k nodes.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        if (head == null || k < 1) {
            throw new IllegalArgumentException("invalid argument");
        }

        LinkedList tail = head;
        while (tail != null && k > 1) {
            k--;
            tail = tail.next;
        }

        if (tail == null) throw new IllegalArgumentException("not enough nodes");

        LinkedList curr = head;
        LinkedList prev = null;

        while (tail.next != null) {
            prev = curr;
            curr = curr.next;
            tail = tail.next;
        }

        if (prev == null) {
            head.value = head.next.value;
            head.next = head.next.next;
        } else {
            prev.next = curr.next;
        }

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
