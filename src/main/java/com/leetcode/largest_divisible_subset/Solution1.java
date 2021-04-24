/**
 * Leetcode - largest_divisible_subset
 */
package com.leetcode.largest_divisible_subset;
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

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
        }

        int index = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[i][0]) {
                max = dp[i][0];
                index = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (index != -1) {
            ans.add(nums[index]);
            index = dp[index][1];
        }
        return ans;
    }

}
