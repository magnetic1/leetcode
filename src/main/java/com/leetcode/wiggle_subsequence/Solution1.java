/**
 * Leetcode - wiggle_subsequence
 */
package com.leetcode.wiggle_subsequence;
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

    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        int ret = 1;
        int preDiff = nums[0] - nums[1];

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                ret++;
                preDiff = diff;
            }
        }

        return ret;
    }

}
