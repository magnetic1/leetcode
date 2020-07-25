package com.leetcode.rotate_list;

import com.ciaoshen.leetcode.util.ListNode;

public class Solution3 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        k = k % len;
        ListNode lo = head, hi = head;
        for (int i = 0; i < k; i++) {
            hi = hi.next;
        }
        while (hi.next != null) {
            hi = hi.next;
            lo = lo.next;
        }
        // the order matters
        // special case, when k = 0, both lo and hi will stop at the last node
        hi.next = head;
        head = lo.next;
        lo.next = null;
        return head;
    }
}
