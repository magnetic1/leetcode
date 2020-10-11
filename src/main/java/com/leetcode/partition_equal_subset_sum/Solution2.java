/**
 * Leetcode - partition_equal_subset_sum
 */
package com.leetcode.partition_equal_subset_sum;
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

    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int currSum : nums) {
            for (int j = target; currSum <= j; j--) {
                if (dp[target]) return true;
                dp[j] = dp[j] || dp[j - currSum];
            }
        }

        return dp[target];
    }

}
