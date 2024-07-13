package com.priyakdey.linkedlist;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class ZipLinkedList {

    // You're given the head of a Singly Linked List of arbitrary length k. Write a function that
    // zips the Linked List in place (i.e., doesn't create a brand new list) and returns its head.
    //
    // A Linked List is zipped if its nodes are in the following order, where k is the length of
    // the Linked List:
    //
    // 1st node -> kth node -> 2nd node -> (k - 1)th node -> 3rd node -> (k - 2)th node -> ...
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.
    //
    // You can assume that the input Linked List will always have at least one node; in other
    // words, the head will never be None / null.

    public LinkedList zipLinkedList(LinkedList linkedList) {
        Objects.requireNonNull(linkedList);
        if (linkedList.next == null || linkedList.next.next == null) {
            return linkedList;
        }

        LinkedList mid = findMid(linkedList);
        LinkedList next = mid.next;
        mid.next = null;

        LinkedList head2 = reverseList(next);

        LinkedList curr1 = linkedList.next;
        LinkedList prev = linkedList;
        LinkedList curr2 = head2;

        while (curr1 != null) {
            LinkedList nextNode = curr2.next;
            prev.next = curr2;
            curr2.next = curr1;
            prev = curr1;
            curr1 = curr1.next;
            curr2 = nextNode;
        }

        prev.next = curr2;

        return linkedList;
    }

    private LinkedList reverseList(LinkedList head) {
        LinkedList prev = null, curr = head;
        while (curr != null) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private LinkedList findMid(LinkedList head) {
        LinkedList curr = head.next;
        LinkedList mid = head;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
