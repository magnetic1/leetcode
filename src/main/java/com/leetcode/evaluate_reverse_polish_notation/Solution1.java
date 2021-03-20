/**
 * Leetcode - evaluate_reverse_polish_notation
 */
package com.leetcode.evaluate_reverse_polish_notation;

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

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("/")) {
                int left = deque.pop(), right = deque.pop();
                deque.push(right / left);
            } else if (token.equals("*")) {
                int left = deque.pop(), right = deque.pop();
                deque.push(right * left);
            } else if (token.equals("+")) {
                int left = deque.pop(), right = deque.pop();
                deque.push(right + left);
            } else if (token.equals("-")) {
                int left = deque.pop(), right = deque.pop();
                deque.push(right - left);
            } else {
                deque.push(Integer.valueOf(token));
            }
        }

        return deque.pop();
    }

}
