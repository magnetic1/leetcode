/**
 * Leetcode - palindrome_linked_list
 */
package com.leetcode.palindrome_linked_list;
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

    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode first = node, second = head;
        while(second != null) {
            first = next(first);
            second = next(next(second));
        }

        ListNode h1 = first.next;
        if(h1 == null) { return true; }
        ListNode h2 = h1.next;
        h1.next = null;
        while(h2 != null) {
            ListNode next = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = next;
        }
        first.next = h1;

        ListNode nd = h1;
        while(nd != null) {
            if(head.val == nd.val) {
                head = head.next;
                nd = nd.next;
            } else {
                return false;
            }
        }

        return true;
    }

    ListNode next(ListNode node) {
        if(node == null) {
            return null;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(0);

        Solution1 solution = new Solution1();
        solution.isPalindrome(node);
    }

}
