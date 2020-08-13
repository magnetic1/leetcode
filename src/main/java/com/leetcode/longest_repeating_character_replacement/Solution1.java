/**
 * Leetcode - longest_repeating_character_replacement
 */
package com.leetcode.longest_repeating_character_replacement;

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

    public int characterReplacement(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        }

        char[] chars = s.toCharArray();
        int d_inx = 1;
        int d_num = 0;
        int ret = 1;
        int start = 0;

        for (int end = start + 1; end < chars.length; end++) {
            char c = chars[start];
            if (c != chars[end]) {
                if (d_num == 0) {
                    d_inx = end;
                }
                if (d_num < k) {
                    d_num++;
                } else {
                    start = d_inx;
                    d_num = 0;
                    end = start;
                    continue;
                }
            }

            ret = Math.max(ret, end - start + 1);
        }

        if (d_num < k) {
            int p = Math.min(k - d_num, start);
            ret = Math.max(ret, chars.length - start + p);
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.characterReplacement("ABBB", 2);
    }
}
