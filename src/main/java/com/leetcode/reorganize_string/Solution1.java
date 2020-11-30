/**
 * Leetcode - reorganize_string
 */
package com.leetcode.reorganize_string;
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

    public String reorganizeString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        int n = S.length(), boundary = (n + 1) / 2;
        int[] p = new int[26];

        for(int i = 0; i < n; i++) {
            char c = S.charAt(i);
            p[c - 'a']++;
        }
        int max = 0, maxIndex = 0;
        for(int i = 0; i < 26; i++) {
            if(p[i] > boundary) {
                return "";
            }
            if (p[i] > max) {
                maxIndex = i;
                max = p[i];
            }
        }

        int even = 0, odd = 1;
        char[] chars = new char[n];
        while(p[maxIndex] > 0 && p[maxIndex] > 0) {
            chars[even] = (char)(maxIndex + 'a');
            even += 2;
            p[maxIndex]--;
        }

        for (int i = 0; i < 26; i++) {
            while(even < n && p[i] > 0) {
                chars[even] = (char)(i + 'a');
                even += 2;
                p[i]--;
            }
            while(odd < n && p[i] > 0) {
                chars[odd] = (char)(i + 'a');
                odd += 2;
                p[i]--;
            }
        }
        return new String(chars);
    }

}
