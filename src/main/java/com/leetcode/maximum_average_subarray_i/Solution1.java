/**
 * Leetcode - maximum_average_subarray_i
 */
package com.leetcode.maximum_average_subarray_i;
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

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;
        for(int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }

}
