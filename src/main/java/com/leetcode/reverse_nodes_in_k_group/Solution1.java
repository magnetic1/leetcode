/**
 * Leetcode - reverse_nodes_in_k_group
 */
package com.leetcode.reverse_nodes_in_k_group;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode l1 = new ListNode(0);
        l1.next = head;
        reverse(head, l1, head, 1, k);
        return l1.next;
    }

    public ListNode reverse(ListNode head, ListNode lastNode, ListNode node, int i, int max) {
        if (node == null) {
            return null;
        }

        if (i == max) {
            ListNode next = node.next;
            node.next = lastNode;

            head.next = next;

            return node;
        } else if (i == 1) {
            ListNode endNode = reverse(head, node, node.next, i + 1, max);
            lastNode.next = endNode;

            return endNode;
        } else {
            ListNode next = node.next;
            node.next = lastNode;
            return reverse(head, node, next, i + 1, max);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        l1.next.next.next = l2;

        System.out.println(l1);

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reverseKGroup(l1, 3));
    }

}
