/**
 * Leetcode - reverse_linked_list_ii
 */
package com.leetcode.reverse_linked_list_ii;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        ListNode l = new ListNode(0);
        l.next = head;
        head = l;
        int i = 1;
        while(i < left) {
            head = head.next;
            i++;
        }
        ListNode res = reverse(head, head, 0, right - left);

        return l.next;
    }

    ListNode reverse(ListNode head, ListNode pre, int i, int len) {
        ListNode node = pre.next;
        if(i == len) {
            ListNode next = node.next;
            head.next = node;
            node.next = pre;
            return next;
        } else if(i == 0) {
            ListNode res = reverse(head, node, i + 1, len);
            node.next = res;
            return res;
        } else {
            ListNode res = reverse(head, node, i + 1, len);
            node.next = pre;
            return res;
        }
    }

}
