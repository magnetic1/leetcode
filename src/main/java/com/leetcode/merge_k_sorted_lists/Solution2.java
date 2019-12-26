/**
 * Leetcode - merge_k_sorted_lists
 */
package com.leetcode.merge_k_sorted_lists;
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode s = new ListNode(0);
        ListNode ite = s;
        int  minIndex = minList(lists);
        while (minIndex != Integer.MAX_VALUE) {
            ite.next = lists[minIndex];

            ite = ite.next;
            lists[minIndex] = lists[minIndex].next;
            minIndex = minList(lists);
        }

        return s.next;
    }

    public int minList(ListNode[] lists) {
        int minIndex = Integer.MAX_VALUE;
        ListNode minListNode = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (minListNode == null || lists[i].val < minListNode.val) {
                    minListNode = lists[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }


}
