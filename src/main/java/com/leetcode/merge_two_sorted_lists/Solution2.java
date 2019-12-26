package com.leetcode.merge_two_sorted_lists;

import java.util.Optional;
import java.util.function.*;

import com.ciaoshen.leetcode.util.*;

/**
 * Leetcode - merge_two_sorted_lists
 *
 * <p>
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
@SuppressWarnings({"WeakerAccess"})
class Solution2 implements Solution {

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

    public static void main(String[] args) {
        Function<Integer, Function<ListNode, ListNode>> add =
                integer -> (node -> node.next = new ListNode(integer));


        ListNode l1 = new ListNode(1);
        Optional<ListNode> lop1 = Optional.of(l1);
        lop1.map(add.apply(2))
                .map(add.apply(4));


        ListNode l2 = new ListNode(1);
        Optional<ListNode> lop2 = Optional.of(l2);
        lop2.map(add.apply(3))
                .map(add.apply(4));

        System.out.println(l1);
        System.out.println(l2);

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.mergeTwoLists(l1, l2));
    }

}
