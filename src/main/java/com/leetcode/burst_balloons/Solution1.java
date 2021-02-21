/**
 * Leetcode - burst_balloons
 */
package com.leetcode.burst_balloons;
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


    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        val[0] = val[n + 1] = 1;
        System.arraycopy(nums, 0, val, 1, n);

        for(int i = n; i >= 0; i--) {
            for(int j = i + 2; j <= n + 1; j++) {
                for(int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[j] * val[k];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }

        return dp[0][n + 1];
    }
}
