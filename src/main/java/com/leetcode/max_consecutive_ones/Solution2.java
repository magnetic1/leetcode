/**
 * Leetcode - max_consecutive_ones
 */
package com.leetcode.max_consecutive_ones;
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

    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, count = 0;

        while(right < nums.length) {
            int num = nums[right];
            if(num == 0 || count != 0) {
                if(nums[left] == 0) {
                    count--;
                }
                if(num == 0) {
                    count++;
                }
                left++;
            }
            right++;
        }

        return right - left;
    }

}
