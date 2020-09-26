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
class Solution1 implements Solution {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][][] dp = new int [3][m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[0][i][0] = 0;
            dp[1][i][0] = 0;
        }
        for(int i = 0; i <= n; i++) {
            dp[1][0][i] = 0;
            dp[2][0][i] = 0;
        }
        int ret = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == 0) {
                    dp[0][i][j] = 0;
                    dp[1][i][j] = 0;
                    dp[2][i][j] = 0;
                } else {
                    int len = dp[0][i-1][j];
                    len = Math.min(len, dp[1][i-1][j-1]);
                    len = Math.min(len, dp[2][i][j-1]);
                    len = len + 1;

                    ret += len;
                    dp[0][i][j] = dp[0][i-1][j] + 1;
                    dp[1][i][j] = len;
                    dp[2][i][j] = dp[2][i][j-1] + 1;
                }
            }
        }

        return ret;
    }

}
