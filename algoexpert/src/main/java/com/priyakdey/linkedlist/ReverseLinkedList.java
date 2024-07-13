package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class ReverseLinkedList {

    // Write a function that takes in the head of a Singly Linked List, reverses the list in
    // place (i.e., doesn't create a brand new list), and returns its new head.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.
    // You can assume that the input Linked List will always have at least one node; in other
    // words, the head will never be None / null.

    public static LinkedList reverseLinkedList(LinkedList head) {
        // return reverseUsingIteration(head);
        return reverseUsingRecursion(head, null);

        // return null;
    }

    private static LinkedList reverseUsingIteration(LinkedList head) {
        LinkedList prev = null, curr = head;
        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static LinkedList reverseUsingRecursion(LinkedList curr, LinkedList prev) {
        if (curr == null) return prev;

        LinkedList next = curr.next;
        curr.next = prev;
        return reverseUsingRecursion(next, curr);
    }


    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
