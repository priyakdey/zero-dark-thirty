package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 * @since 14-07-2024
 */
public class MiddleNode {

    // You're given a Linked List with at least one node. Write a function that returns the
    // middle node of the Linked List. If there are two middle nodes (i.e. an even length list),
    // your function should return the second of these nodes.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.

    public LinkedList middleNode(LinkedList linkedList) {
        if (linkedList == null || linkedList.next == null) return linkedList;

        LinkedList curr = linkedList;
        LinkedList mid = linkedList;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
