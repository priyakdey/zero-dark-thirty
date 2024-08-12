package com.priyakdey;

import com.priyakdey.models.ListNode;

public class LinkedListCycle {

    // https://leetcode.com/problems/linked-list-cycle/description/

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        return slow == fast;
    }

}
