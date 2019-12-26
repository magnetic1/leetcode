package com.leetcode.remove_nth_node_from_end_of_list;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * Leetcode - remove_nth_node_from_end_of_list
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */

@SuppressWarnings({"WeakerAccess"})
class Solution1 implements Solution {
    static int num = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head != null) {
            head.next = removeNthFromEnd(head.next, n);
        } else {
            return null;
        }

        num++;

        if (num == n) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = null;
        for (int i = 5; i > 0; i--) {
            ListNode node = new ListNode(i);
            if (listNode == null) {
                listNode = node;
            } else {
                node.next = listNode;
                listNode = node;
            }
        }

        Solution1 solution1 = new Solution1();
        listNode = new ListNode(1);
        System.out.println(listNode);
        System.out.println(solution1.removeNthFromEnd(listNode, 1));

    }

}
