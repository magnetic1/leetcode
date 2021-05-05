/**
 * Leetcode - delete_and_earn
 */
package com.leetcode.delete_and_earn;
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

    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int[] sum = new int[2];
        sum[1] = nums[0];
        for (int i = 1; i < size; i++) {
            int tmp = sum[1];
            sum[1] = sum[0] + nums[i];
            sum[0] = Math.max(tmp, sum[0]);
        }

        return Math.max(sum[0], sum[1]);
    }

}
