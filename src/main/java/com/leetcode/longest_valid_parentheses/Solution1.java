/**
 * Leetcode - longest_valid_parentheses
 */
package com.leetcode.longest_valid_parentheses;
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

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int res = 0;
        int tmp = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                // else if (c == ')')
            } else  {
                if (stack.isEmpty()){
                    res = Math.max(res, tmp);
                    tmp = 0;
                } else {
                    stack.pop();
                    tmp++;
                }
            }
        }
        if (!stack.isEmpty())
        res = Math.max(res, tmp);

        return res * 2;
    }

}
