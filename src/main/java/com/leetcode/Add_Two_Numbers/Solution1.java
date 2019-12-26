/**
 * Leetcode - Add_Two_Numbers
 */
package com.leetcode.Add_Two_Numbers;
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

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int r = l1.val + l2.val;
        int x = r % 10;
        int d = r / 10;

        ListNode listNode = new ListNode(x);
        ListNode result = listNode;

        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;

            r = l1.val + l2.val + d;
            // 当前位的值
            x = r % 10;
            // 进位值
            d = r / 10;

            listNode.next = new ListNode(x);
            listNode = listNode.next;
        }
        if (l1.next == null) {
            l1 = l2;
        }

        while (l1.next != null) {
            l1 = l1.next;
            r = l1.val + d;
            // 当前位的值
            x = r % 10;
            // 进位值
            d = r / 10;

            listNode.next = new ListNode(x);
            listNode = listNode.next;
        }
        if (d == 1) {
            listNode.next = new ListNode(1);
            listNode = listNode.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(new Solution1().addTwoNumbers(l1,l2));
    }
}
