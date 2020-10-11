/**
 * Leetcode - middle_of_the_linked_list
 */
package com.leetcode.middle_of_the_linked_list;
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

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = next(slow);

        while(fast != null) {
            fast = next(next(fast));
            slow = next(slow);
        }

        return slow;
    }

    ListNode next(ListNode node) {
        if(node == null) {
            return null;
        }
        return node.next;
    }

}
