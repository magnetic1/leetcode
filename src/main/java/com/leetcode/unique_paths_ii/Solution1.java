/**
 * Leetcode - unique_paths_ii
 */
package com.leetcode.unique_paths_ii;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }

        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                if (j == 0 && i == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.uniquePathsWithObstacles(
                new int[][]{
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0},
                }));
    }


}
