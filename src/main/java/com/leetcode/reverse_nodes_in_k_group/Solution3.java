package com.leetcode.reverse_nodes_in_k_group;

import com.ciaoshen.leetcode.util.ListNode;

public class Solution3 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 0; i < k - 1; i ++) {
            if (tail.next != null) {
                tail = tail.next;
            } else {
                return head;
            }
        }
        ListNode nextList = null;
        if (tail.next != null) {
            nextList = reverseKGroup(tail.next, k);
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != tail) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        head.next = nextList;
        return cur;
    }
}
