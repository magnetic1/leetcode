/**
 * Leetcode - Longest_Palindromic_Substring
 */
package com.leetcode.Longest_Palindromic_Substring;
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
 *
 * Dynamic Programming
 */
class Solution2 implements Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int length = s.length();
        boolean[][] P = new boolean[length][length];
        P[length - 1][length - 1] = true;

        int start = 0, end = 0;

        for (int i = 0; i < length - 1; i++) {
            P[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                P[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }

        for (int m = 0; m < length; m++) {
            int i = length - 1 - m;
            for (int j = i + 2; j < length; j++) {
                if (P[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    P[i][j] = true;
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.longestPalindrome("abcba"));
    }

}
