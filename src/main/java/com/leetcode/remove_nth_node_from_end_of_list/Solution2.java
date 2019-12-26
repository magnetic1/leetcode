package com.leetcode.remove_nth_node_from_end_of_list;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 * Leetcode - remove_nth_node_from_end_of_list
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
@SuppressWarnings({"WeakerAccess"})
class Solution2 implements Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int num = remove(head, n);

        if (num == n) {
            head = head.next;
        }

        return head;
    }

    private int remove(ListNode head, int n) {
        if (head == null) {
            return 0;
        }

        int num = remove(head.next, n);

        if (num == n) {
            head.next = head.next.next;
        }

        return num + 1;
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
        listNode = new ListNode(1);
        System.out.println(listNode);
        System.out.println(solution2.removeNthFromEnd(listNode, 1));

    }
}
