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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode l1 = new ListNode(0);
        l1.next = head;

        reverse(head, l1, head, 1, k);

        return l1.next;
    }

    public ListNode reverse(ListNode head, ListNode prev, ListNode cur, int i, int max) {
        if (cur == null) {
            return null;
        }

        if (i == max) {
            ListNode next = cur.next;
            cur.next = prev;
            head.next = next;

            reverse(next, head, next, 1, max);
            return cur;
        } else if (i == 1) {
            ListNode endNode = reverse(head, cur, cur.next, i + 1, max);
            if (endNode != null) {
                prev.next = endNode;
                return endNode;
            }
        } else {
            ListNode endNode = reverse(head, cur, cur.next, i + 1, max);
            if (endNode != null) {
                cur.next = prev;
                return endNode;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
//        l2.next.next = new ListNode(3);

        l1.next.next.next = l2;

        System.out.println(l1);

        Solution2 solution1 = new Solution2();

        System.out.println(solution1.reverseKGroup(l1, 3));
    }


}
