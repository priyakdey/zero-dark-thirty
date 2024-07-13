package com.priyakdey.linkedlist;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class LinkedListPalindrome {

    // Write a function that takes in the head of a Singly Linked List and returns a boolean
    // representing whether the linked list's nodes form a palindrome. Your function shouldn't
    // make use of any auxiliary data structure.
    //
    // A palindrome is usually defined as a string that's written the same forward and backward.
    // For a linked list's nodes to form a palindrome, their values must be the same when read
    // from left to right and from right to left. Note that single-character strings are
    // palindromes, which means that single-node linked lists form palindromes.
    //
    // Each LinkedList node has an integer value as well as a next node pointing to the next node
    // in the list or to None / null if it's the tail of the list.
    //
    // You can assume that the input linked list will always have at least one node; in other
    // words, the head will never be None / null.

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean linkedListPalindrome(LinkedList head) {
        Objects.requireNonNull(head);
        if (head.next == null) return true;

        LinkedList mid = findMid(head);
        LinkedList head2 = mid.next;
        mid.next = null;

        head2 = reverse(head2);

        LinkedList curr1 = head, curr2 = head2;

        while (curr2 != null) {
            if (curr1.value != curr2.value) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;
    }

    private LinkedList reverse(LinkedList head) {
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
        LinkedList mid = head;
        LinkedList curr = head.next;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

}
