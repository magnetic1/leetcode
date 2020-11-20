/**
 * Leetcode - insertion_sort_list
 */
package com.leetcode.insertion_sort_list;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;

        sort(pre);
        return pre.next;
    }

    void sort(ListNode pre) {
        ListNode node = pre.next;

        while(node.next != null) {
            ListNode temp = node.next;
            node.next = temp.next;

            ListNode last = pre;
            ListNode iter = pre.next;

            while(iter != node.next && iter.val < temp.val) {
                last = iter;
                iter = iter.next;
            }

            ListNode next = last.next;
            last.next = temp;
            temp.next = next;

            if(last == node) {
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode node = newListNode(new int[]{
                -1, 5, 3, 4, 0
        });
        solution.insertionSortList(node);
    }

    static ListNode newListNode(int[] nums) {
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        for (int i : nums) {
            node.next = new ListNode(i);
            node = node.next;
        }

        return pre.next;
    }
}
