/**
 * Leetcode - valid_anagram
 */
package com.leetcode.valid_anagram;
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

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        int[] p = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++) {
            p[s.charAt(i) - 'a']++;
            p[t.charAt(i) - 'a']--;
        }

        for (int j : p) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }

}
