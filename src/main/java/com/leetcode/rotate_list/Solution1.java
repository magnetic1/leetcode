/**
 * Leetcode - rotate_list
 */
package com.leetcode.rotate_list;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    private static int len = 0;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        return rotateRight(head, head, k, 0);
    }

    public ListNode rotateRight(ListNode node, ListNode head, int k, int index) {
        ListNode listNode;

        if (node.next == null) {
            len = index + 1;
            node.next = head;
            listNode = node;
        } else {
            listNode = rotateRight(node.next, head, k, index + 1);
        }

        k = k % len;

        if (len - k - 1 == index) {
            ListNode newHead = node.next;
            node.next = null;
            return newHead;
        }

        return listNode;
    }


    public static void main(String[] args) {

    }
}
