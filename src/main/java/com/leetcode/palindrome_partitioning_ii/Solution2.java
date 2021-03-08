/**
 * Leetcode - palindrome_partitioning_ii
 */
package com.leetcode.palindrome_partitioning_ii;
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

    public int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int i = n - 2; i >= 0; i--) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            for(int j = i + 2; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            if(dp[0][i]) {
                f[i] = 0;
            } else {
                for(int j = 0; j < i; j++) {
                    if(dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

}
