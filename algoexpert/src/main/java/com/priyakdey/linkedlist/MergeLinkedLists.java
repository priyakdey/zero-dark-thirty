package com.priyakdey.linkedlist;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class MergeLinkedLists {

    // Write a function that takes in the heads of two Singly Linked Lists that are in sorted
    // order, respectively. The function should merge the lists in place (i.e., it shouldn't
    // create a brand new list) and return the head of the merged list; the merged list should be
    // in sorted order.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.
    //
    // You can assume that the input linked lists will always have at least one node; in other
    // words, the heads will never be None / null.

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        if (headOne == null && headTwo == null) return null;
        if (headOne == null) return headTwo;
        if (headTwo == null) return headOne;

        LinkedList head = headOne;
        LinkedList prev = headOne;
        LinkedList curr1 = headOne.next;
        LinkedList curr2 = headTwo;

        if (headTwo.value < headOne.value) {
            head = headTwo;
            prev = headTwo;
            curr1 = headTwo.next;
            curr2 = headOne;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1.value <= curr2.value) {
                prev = curr1;
                curr1 = curr1.next;
            } else {
                LinkedList next2 = curr2.next;
                prev.next = curr2;
                curr2.next = curr1;
                prev = curr2;
                curr2 = next2;
            }
        }

        if (curr1 == null) {
            prev.next = curr2;
        }

        return head;
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
