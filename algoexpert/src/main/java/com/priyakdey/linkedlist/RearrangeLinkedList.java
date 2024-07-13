package com.priyakdey.linkedlist;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class RearrangeLinkedList {

    //  Write a function that takes in the head of a Singly Linked List and an integer k,
    //  rearranges the list in place (i.e., doesn't create a brand new list) around nodes with
    //  value k, and returns its new head.
    //
    //  Rearranging a Linked List around nodes with value k means moving all nodes with a
    //  value smaller than k before all nodes with value k and moving all nodes with a
    //  value greater than k after all nodes with value k.
    //
    //  All moved nodes should maintain their original relative ordering if possible.
    //
    //  Note that the linked list should be rearranged even if it doesn't have any nodes
    //  with value k.
    //
    //  Each LinkedList node has an integer value as well as a next node pointing to the
    //  next node in the list or to None / null if it's the tail of the list.
    //
    //  You can assume that the input Linked List will always have at least one node; in
    //  other words, the head will never be None / null.

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        Objects.requireNonNull(head);
        if (head.next == null) return head;

        LinkedList head1 = new LinkedList(k - 1), curr1 = head1;      // values < k
        LinkedList head2 = new LinkedList(k), curr2 = head2;                  // values == k
        LinkedList head3 = new LinkedList(k + 1), curr3 = head3;      // values > k

        LinkedList curr = head;

        while (curr != null) {
            if (curr.value < k) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else if (curr.value == k) {
                curr2.next = curr;
                curr2 = curr2.next;
            } else {
                curr3.next = curr;
                curr3 = curr3.next;
            }
            curr = curr.next;
        }

        curr1.next = null;
        curr2.next = null;
        curr3.next = null;

        if (head1.next != null) {
            head = head1.next;
            if (head2.next != null) {
                curr1.next = head2.next;
                curr2.next = head3.next;
            } else {
                curr1.next = head3.next;
            }
        } else if (head2.next != null) {
            head = head2.next;
            curr2.next = head3.next;
        } else {
            head = head3.next;
        }

        return head;
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
