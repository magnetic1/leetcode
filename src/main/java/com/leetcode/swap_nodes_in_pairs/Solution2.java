/**
 * Leetcode - swap_nodes_in_pairs
 */
package com.leetcode.swap_nodes_in_pairs;
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

    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;

        ListNode last = listNode;
        while (true) {
            if (head != null && head.next != null) {
                ListNode secondNode = head.next;
                head.next = head.next.next;
                secondNode.next = head;

                last.next = secondNode;
                last = head;
                head = last.next;
            } else {
                break;
            }
        }
        return listNode.next;
    }

}
