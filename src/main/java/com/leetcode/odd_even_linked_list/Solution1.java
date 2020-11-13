/**
 * Leetcode - odd_even_linked_list
 */
package com.leetcode.odd_even_linked_list;
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode even = head;
        ListNode odd = even.next;

        while(odd != null && odd.next != null) {
            ListNode evenNext = even.next;
            ListNode oddNext = odd.next;
            odd.next = odd.next.next;
            even.next = oddNext;
            oddNext.next = evenNext;

            even = even.next;
            odd = odd.next;
        }
        return head;
    }

}
