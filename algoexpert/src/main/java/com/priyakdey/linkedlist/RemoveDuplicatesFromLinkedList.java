package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 * @since 14-07-2024
 */
public class RemoveDuplicatesFromLinkedList {

    // You're given the head of a Singly Linked List whose nodes are in sorted order with respect
    // to their values. Write a function that returns a modified version of the Linked List that
    // doesn't contain any nodes with duplicate values. The Linked List should be modified in
    // place (i.e., you shouldn't create a brand new list), and the modified Linked List should
    // still have its nodes sorted with respect to their values.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        if (linkedList == null || linkedList.next == null) return linkedList;

        LinkedList attachTo = linkedList;
        LinkedList curr = linkedList.next;

        int lastUniqValue = linkedList.value;

        while (curr != null) {
            if (curr.value != lastUniqValue) {
                attachTo.next = curr;
                attachTo = attachTo.next;
                lastUniqValue = curr.value;
            }
            curr = curr.next;
        }

        attachTo.next = null;
        return linkedList;
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
