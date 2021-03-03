/**
 * Leetcode - remove_invalid_parentheses
 */
package com.leetcode.remove_invalid_parentheses;
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

    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                left++;
            } else if(c == ')') {
                if(left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        StringBuilder buider = new StringBuilder();
        dfs(s, buider, 0, left, right, 0);

        return new ArrayList<>(set);
    }

    void dfs(String s, StringBuilder buider, int index, int left, int right, int diff) {
        int n = s.length();

        if(n - index < left + right || diff < 0) {
            return;
        }

        if(n == index) {
            set.add(buider.toString());
            return;
        }

        char c = s.charAt(index);
        if(c == '(') {
            if(left > 0) {
                dfs(s, buider, index + 1, left - 1, right, diff);
            }
            diff++;
        } else if(c == ')') {
            if(right > 0) {
                dfs(s, buider, index + 1, left, right - 1, diff);
            }
            diff--;
        }

        buider.append(c);
        dfs(s, buider, index + 1, left, right, diff);
        buider.deleteCharAt(buider.length() - 1);
    }

}
