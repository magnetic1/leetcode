/**
 * Leetcode - combination_sum_iv
 */
package com.leetcode.combination_sum_iv;
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

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[target] = 1;

        return dfs(nums, target, 0, dp);
    }

    int dfs(int[] nums, int target, int sum, int[] dp) {
        if (sum > target) {
            return 0;
        }
        if (dp[sum] != -1) {
            return dp[sum];
        }
        int ans = 0;
        for (int num : nums) {
            ans += dfs(nums, target, sum + num, dp);
        }
        dp[sum] = ans;
        return ans;
    }

}
