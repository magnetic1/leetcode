package com.leetcode.merge_k_sorted_lists;

import com.ciaoshen.leetcode.util.ListNode;

public class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(0, lists.length, lists);
    }

    private ListNode merge(int begin, int end, ListNode[] lists) {
        if (begin == end - 1) {
            return lists[begin];
        }
        if (begin == end - 2) {
            return mergeTwoLists(lists[begin], lists[begin + 1]);
        }
        int mid = (begin + end) / 2;
        ListNode l1 = merge(begin, mid, lists);
        ListNode l2 = merge(mid, end, lists);
        return mergeTwoLists(l1, l2);
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
