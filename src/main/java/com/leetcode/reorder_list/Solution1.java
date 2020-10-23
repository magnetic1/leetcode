/**
 * Leetcode - reorder_list
 */
package com.leetcode.reorder_list;
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

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode second = head;
        ListNode first = second.next;

        while(first.next != null) {
            second = first;
            first = first.next;
        }

        second.next = null;
        reorderList(head.next);

        first.next = head.next;
        head.next = first;
    }

}
