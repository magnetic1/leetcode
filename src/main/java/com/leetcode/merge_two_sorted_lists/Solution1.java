package com.leetcode.merge_two_sorted_lists;

/**
 * Leetcode - merge_two_sorted_lists
 *
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
@SuppressWarnings({"WeakerAccess"})
class Solution1 implements Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode ite = newList;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ite.next = new ListNode(l1.val);
                l1 = (ListNode) l1.next;
            } else {
                ite.next = new ListNode(l2.val);
                l2 = (ListNode) l2.next;
            }
            ite = (ListNode) ite.next;
        }

        while (l1 != null) {
            ite.next = new ListNode(l1.val);
            l1 = (ListNode) l1.next;
            ite = (ListNode) ite.next;
        }

        while (l2 != null) {
            ite.next = new ListNode(l2.val);
            l2 = (ListNode) l2.next;
            ite = (ListNode) ite.next;
        }

        return (ListNode) newList.next;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode l1 = new ListNode(1).add(new ListNode(2)).add(new ListNode(4));
        ListNode l2 = new ListNode(1).add(new ListNode(3)).add(new ListNode(4));

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(solution1.mergeTwoLists(l1, l2));
    }

    static class ListNode extends com.ciaoshen.leetcode.util.ListNode {

        ListNode(int x) {
            super(x);
        }

        public ListNode add(ListNode next) {
            ListNode node = this;
            while (node.next != null) {
                node = (ListNode) node.next;
            }
            node.next = next;
            return this;
        }

    }

}

