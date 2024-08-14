package com.priyakdey;

import com.priyakdey.models.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // return reverseIterative(head);
        return reverseRecursive(head, null);
    }

    private ListNode reverseIterative(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode reverseRecursive(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }

        ListNode next = curr.next;
        curr.next = prev;
        return reverseRecursive(next, curr);
    }

}
