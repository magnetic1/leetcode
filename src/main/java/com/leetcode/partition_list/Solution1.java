/**
 * Leetcode - partition_list
 */
package com.leetcode.partition_list;
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

    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode low = pre, node = pre;

        while(node.next != null && node.next.val < x) {
            low = node.next;
            node = node.next;
        }

        while(node.next != null) {
            if(node.next.val < x) {
                ListNode next = low.next;
                low.next = node.next;
                node.next = node.next.next;
                low.next.next = next;
                low = low.next;
            } else {
                node = node.next;
            }

        }

        return pre.next;
    }

}
