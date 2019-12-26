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
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int res = 0;

        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (s.charAt(i - 1) == ')') {
                    if (i - dp[i - 1] - 1 >= 0) {
                        char f = s.charAt(i - dp[i - 1] - 1);
                        if (f == '(') {
                            dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                        }
                    }
                }

                res = Math.max(dp[i], res);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestValidParentheses("()(()"));
    }

}
