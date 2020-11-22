/**
 * Leetcode - sort_list
 */
package com.leetcode.sort_list;
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

    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode lastNode = head, cur = head.next;

        while(cur != null) {
            if(lastNode.val <= cur.val) {
                lastNode = lastNode.next;
            } else {
                ListNode node = pre;
                while (node.next.val < cur.val) {
                    node = node.next;
                }
                lastNode.next = cur.next;
                cur.next = node.next;
                node.next = cur;
            }
            cur = lastNode.next;
        }

        return pre.next;
    }

}
