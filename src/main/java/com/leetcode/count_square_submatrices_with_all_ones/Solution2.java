/**
 * Leetcode - count_square_submatrices_with_all_ones
 */
package com.leetcode.count_square_submatrices_with_all_ones;
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

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int [m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        int ret = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == 0) {
                    dp[i][j] = 0;
                } else {
                    int len = dp[i-1][j];
                    len = Math.min(len, dp[i-1][j-1]);
                    len = Math.min(len, dp[i][j-1]);
                    len = len + 1;

                    ret += len;
                    dp[i][j] = len;
                }
            }
        }

        return ret;
    }

}
