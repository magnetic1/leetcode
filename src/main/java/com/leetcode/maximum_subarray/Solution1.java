/**
 * Leetcode - maximum_subarray
 */
package com.leetcode.maximum_subarray;

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
    public int maxSubArray(int[] nums) {

        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > (sum + nums[i])) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (max < sum)
                max = sum;
        }

        return max;

    }


}
