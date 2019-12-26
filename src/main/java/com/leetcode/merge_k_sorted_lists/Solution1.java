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
class Solution1 implements Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode sortedList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            sortedList = mergeTwoLists(sortedList, lists[i]);
        }
        return sortedList;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newList = new ListNode(0);
        ListNode ite = newList;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ite.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                ite.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            ite = ite.next;
        }

        if (l2 != null) {
            ite.next = l2;
        } else if (l1 != null) {
            ite.next = l1;
        }

        return newList.next;
    }


}
