/**
 * Leetcode - generate_parentheses
 */
package com.leetcode.generate_parentheses;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == 2 * max) {
            ans.add(cur);
        }

        if (close < open) {
            backtrack(ans, cur + ')', open, close + 1, max);
        }
        if (open < max) {
            backtrack(ans, cur + '(', open + 1, close, max);
        }
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.generateParenthesis(3));
    }
}
