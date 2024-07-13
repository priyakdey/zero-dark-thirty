package com.priyakdey.linkedlist;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 14-07-2024
 */
public class SumOfLinkedLists {

    // You're given two Linked Lists of potentially unequal length. Each Linked List represents a
    // non-negative integer, where each node in the Linked List is a digit of that integer, and
    // the first node in each Linked List always represents the least significant digit of the
    // integer. Write a function that returns the head of a new Linked List that represents the
    // sum of the integers represented by the two input Linked Lists.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list. The value of each LinkedList
    // node is always in the range of 0 - 9.
    //
    // Note: your function must create and return a new Linked List, and you're not allowed to
    // modify either of the input Linked Lists.

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        Objects.requireNonNull(linkedListOne);
        Objects.requireNonNull(linkedListTwo);

        LinkedList dummyHead = new LinkedList(0);
        LinkedList curr = dummyHead;

        LinkedList curr1 = linkedListOne, curr2 = linkedListTwo;

        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int value = curr1.value + curr2.value + carry;
            carry = value / 10;
            value = value % 10;
            curr.next = new LinkedList(value);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int value = curr1.value + carry;
            carry = value / 10;
            value = value % 10;
            curr.next = new LinkedList(value);
            curr = curr.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int value = curr2.value + carry;
            carry = value / 10;
            value = value % 10;
            curr.next = new LinkedList(value);
            curr = curr.next;
            curr2 = curr2.next;
        }

        if (carry == 1) {
            curr.next = new LinkedList(1);
        }

        return dummyHead.next;
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
