/**
 * Leetcode - longest_substring_without_repeating_characters
 */
package com.leetcode.longest_substring_without_repeating_characters;
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
    public int lengthOfLongestSubstring(String s) {
        int L = s.length();
        boolean[] occupied = new boolean[256];
        int longestLength = 0;
        int start = 0, end = 0;
        while (end < L) {
            char c = s.charAt(end);
            if (!occupied[c]) {
                occupied[c] = true;
                end++;
            } else {
                while (occupied[c]) {
                    occupied[s.charAt(start++)] = false;
                }
                occupied[c] = true;
                end++;
            }
            if (end - start > longestLength) {
                longestLength = end - start;
            }
        }


        return longestLength;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("pwwkew"));
    }
}
