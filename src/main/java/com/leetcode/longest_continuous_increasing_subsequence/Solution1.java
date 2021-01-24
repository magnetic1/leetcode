/**
 * Leetcode - longest_continuous_increasing_subsequence
 */
package com.leetcode.longest_continuous_increasing_subsequence;
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

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int ans = 1, len = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                len++;
            } else {
                len = 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

}
