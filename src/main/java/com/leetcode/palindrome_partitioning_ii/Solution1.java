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
class Solution1 implements Solution {

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

        // int start = 0, min = Integer.MIN_VALUE, num = 0;
        // for(int i = 0; i < n; i++) {
        //     if(dp[start][i]) {
        //         start = i + 1;
        //         num++;
        //     }
        // }

        return dfs(dp, 0, n - 1) - 1;
    }

    int dfs(boolean[][] dp, int i, int j) {
        if(i > j) {
            return 0;
        }
        int min = Integer.MAX_VALUE , num = 0;
        for(int k = i; k <= j; k++) {
            if(dp[i][k]) {
                min = Math.min(min, 1 + dfs(dp, k + 1, j));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.minCut("aab");
    }

}
