package com.leetcode.remove_nth_node_from_end_of_list;

import com.ciaoshen.leetcode.util.*;

public class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
//        ListNode fast = dummy;
        ListNode slow = dummy;

        while(n > 0) {
            head = head.next;
            n--;
        }

        while(head != null) {
            head = head.next;
            slow = slow.next;
        }

        // nth from the end is "slow", now delete it
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = null;
        for (int i = 5; i > 0; i--) {
            ListNode node = new ListNode(i);
            if (listNode == null) {
                listNode = node;
            } else {
                node.next = listNode;
                listNode = node;
            }
        }

        Solution2 solution2 = new Solution2();
//        listNode = new ListNode(1);
        System.out.println(listNode);
        System.out.println(solution2.removeNthFromEnd(listNode, 5));

    }
}
