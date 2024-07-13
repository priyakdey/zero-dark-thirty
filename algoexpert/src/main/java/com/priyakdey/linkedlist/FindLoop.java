package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class FindLoop {

    // Write a function that takes in the head of a Singly Linked List that contains a loop (in
    // other words, the list's tail node points to some node in the list instead of None / null).
    // The function should return the node (the actual node--not just its value) from which the
    // loop originates in constant space.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list.

    public static LinkedList findLoop(LinkedList head) {
        LinkedList fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
