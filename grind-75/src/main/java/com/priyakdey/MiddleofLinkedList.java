package com.priyakdey;

import com.priyakdey.models.ListNode;

public class MiddleofLinkedList {
    // https://leetcode.com/problems/middle-of-the-linked-list/description/

    public ListNode middleNode(ListNode head) {
        ListNode curr = head.next, mid = head;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

}
