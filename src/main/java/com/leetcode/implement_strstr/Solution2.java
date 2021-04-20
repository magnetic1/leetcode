/**
 * Leetcode - implement_strstr
 */
package com.leetcode.implement_strstr;
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

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        int m = needle.length();
        int n = haystack.length();

        int[] next = new int[m];
        next[0] = -1;
        for (int i = 0, j = -1; i < m - 1; ) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        for (int i = 0, j = 0; i < n; ) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }

            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }

}
