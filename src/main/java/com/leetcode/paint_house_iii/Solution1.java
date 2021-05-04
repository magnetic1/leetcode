/**
 * Leetcode - paint_house_iii
 */
package com.leetcode.paint_house_iii;
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

    static final int INFTY = Integer.MAX_VALUE / 2;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][n + 1][target + 1];

        // dp 所有元素初始化为极大值
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                Arrays.fill(dp[i][j], INFTY);
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (houses[i - 1] != 0 && houses[i - 1] != j) {
                    continue;
                }

                for (int blocks = 1; blocks <= target; blocks++) {
                    for (int color = 1; color <= n; color++) {
                        if (color == j) {
                            dp[i][j][blocks] = Math.min(dp[i][j][blocks], dp[i - 1][j][blocks]);
                        } else {
                            dp[i][j][blocks] = Math.min(dp[i][j][blocks], dp[i - 1][color][blocks - 1]);
                        }
                    }
                    if (dp[i][j][blocks] < INFTY && houses[i - 1] == 0) {
                        dp[i][j][blocks] += cost[i - 1][j - 1];
                    }
                }
            }
        }

        int ans = INFTY;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[m][i][target]);
        }

        return ans == INFTY ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.minCost(
            new int[]{0, 0, 0, 0, 0},
            new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}},
            5, 2, 3
        );
    }
}
