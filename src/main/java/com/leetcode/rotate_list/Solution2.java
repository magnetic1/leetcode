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
class Solution2 implements Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }

        int len = nodeList.size();
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode newEnd = nodeList.get(len - 1 - k);
        ListNode newHead = newEnd.next;

        nodeList.get(len - 1).next = head;
        newEnd.next = null;

        return newHead;
    }

}
