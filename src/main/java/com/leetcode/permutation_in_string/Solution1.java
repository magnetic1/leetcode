/**
 * Leetcode - permutation_in_string
 */
package com.leetcode.permutation_in_string;
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

    public boolean checkInclusion(String s1, String s2) {
        int[] p = new int[26];
        int m = s1.length(), n = s2.length(), num = 0;

        if(m > n) {
            return false;
        }

        for(int i = 0; i < m; i++) {
            int index = s1.charAt(i) - 'a';
            if(p[index] == 0) {
                num++;
            }
            p[index]++;
        }

        for(int i = 0; i < m; i++) {
            int index = s2.charAt(i) - 'a';
            if(p[index] == 0) {
                num++;
            }
            p[index]--;
            if(p[index] == 0) {
                num--;
            }
        }

        int i = m;
        while(num != 0 && i < n) {
            int index = s2.charAt(i - m) - 'a';
            if(p[index] == 0) {
                num++;
            }
            p[index]++;
            if(p[index] == 0) {
                num--;
            }

            index = s2.charAt(i) - 'a';
            if(p[index] == 0) {
                num++;
            }
            p[index]--;
            if(p[index] == 0) {
                num--;
            }

            i++;
        }

        return num == 0;
    }

}
