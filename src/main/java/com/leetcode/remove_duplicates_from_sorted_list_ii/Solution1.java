/**
 * Leetcode - remove_duplicates_from_sorted_list_ii
 */
package com.leetcode.remove_duplicates_from_sorted_list_ii;
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

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode pre = new ListNode(head.val - 1);
        pre.next = head;

        ListNode node = pre;
        ListNode nextNode = head;

        while(nextNode != null) {
            ListNode node3 = nextNode.next;
            boolean flag = false;
            while(node3 != null && nextNode.val == node3.val) {
                nextNode.next = node3.next;
                node3 = nextNode.next;
                flag = true;
            }

            if(flag) {
                node.next = nextNode.next;
                nextNode = node.next;
            } else {
                node = node.next;
                nextNode = nextNode.next;
            }
        }
        return pre.next;
    }

}
