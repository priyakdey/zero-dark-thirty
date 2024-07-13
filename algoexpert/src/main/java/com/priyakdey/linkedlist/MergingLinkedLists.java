package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 * @since 14-07-2024
 */
public class MergingLinkedLists {

    // You're given two Linked Lists of potentially unequal length. These Linked Lists
    // potentially merge at a shared intersection node. Write a function that returns the
    // intersection node or returns None / null if there is no intersection.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.
    //
    // Note: Your function should return an existing node. It should not modify either Linked
    // List, and it should not create any new Linked Lists.

    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        if (linkedListOne == null || linkedListTwo == null) return null;

        LinkedList curr1 = linkedListOne, curr2 = linkedListTwo;
        int l1Length = length(linkedListOne);
        int l2Length = length(linkedListTwo);
        int offset = Math.abs(l1Length - l2Length);

        if (l1Length > l2Length) {
            curr1 = offsetBy(linkedListOne, offset);
        } else {
            curr2 = offsetBy(linkedListTwo, offset);
        }

        while (curr1 != null && curr2 != null && curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if (curr1 == null || curr2 == null) return null;

        return curr1;
    }

    private LinkedList offsetBy(LinkedList head, int offset) {
        LinkedList curr = head;
        while (offset > 0) {
            curr = curr.next;
            offset--;
        }

        return curr;
    }

    private int length(LinkedList head) {
        int length = 0;
        LinkedList curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        return length;
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
