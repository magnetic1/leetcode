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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() <= k) {return s.length();}

        char[] chars = s.toCharArray();
        int[] hash = new int[26];
        int d_inx = 1;

        int ret = 0, start = 0, maxCount = 0;

        for (int end = 0; end < chars.length; end++) {

            hash[chars[end] - 'A']++;

            maxCount = Math.max(maxCount, hash[chars[end] - 'A']);

            while(end - start + 1 - maxCount > k) {
                hash[chars[start] - 'A']--;
                start++;
            }

            ret = Math.max(ret, end - start + 1);
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.characterReplacement("ABAB", 2);
    }
}
