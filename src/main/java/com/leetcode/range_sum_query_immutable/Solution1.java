/**
 * Leetcode - range_sum_query_immutable
 */
package com.leetcode.range_sum_query_immutable;
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

    static class NumArray {
        int[] sums;
        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

}
