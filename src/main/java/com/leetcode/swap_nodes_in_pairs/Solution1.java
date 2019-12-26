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
class Solution1 implements Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ite = head;

        while (true) {
            if (ite != null && ite.next != null) {
                int value = ite.val;
                ite.val = ite.next.val;
                ite.next.val = value;
                ite = ite.next.next;
            } else {
                break;
            }
        }
        return head;
    }

}
