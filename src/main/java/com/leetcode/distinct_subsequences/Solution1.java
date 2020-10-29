/**
 * Leetcode - distinct_subsequences
 */
package com.leetcode.distinct_subsequences;
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

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n) {
            return 0;
        }
        int[][] p = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            p[i][0] = 1;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <= i && j < n; j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    p[i + 1][j + 1] = p[i][j + 1] + p[i][j];
                } else {
                    p[i + 1][j + 1] = p[i][j + 1];
                }
            }
        }

        return p[m][n];
    }

}
