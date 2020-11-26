/**
 * Leetcode - maximum_gap
 */
package com.leetcode.maximum_gap;
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

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return 0;
        }
        Arrays.sort(nums);

        int res = 0;
        for(int i = 1; i < n; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }

        return res;
    }

}
