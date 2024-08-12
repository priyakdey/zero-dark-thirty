package com.priyakdey;

import com.priyakdey.models.ListNode;

public class MergeTwoSortedList {

    // https://leetcode.com/problems/merge-two-sorted-lists/description/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = list1;
        ListNode curr1 = list1.next, curr2 = list2;
        ListNode prev = list1;

        if (list2.val < list1.val) {
            head = list2;
            curr1 = list2.next;
            curr2 = list1;
            prev = list2;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr1 = curr1.next;
            } else {
                ListNode next = curr2.next;
                prev.next = curr2;
                curr2.next = curr1;
                curr2 = next;
            }
            prev = prev.next;
        }

        if (curr2 != null) {
            prev.next = curr2;
        }

        return head;
    }

}
