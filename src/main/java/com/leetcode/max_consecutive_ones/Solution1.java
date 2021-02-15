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
class Solution1 implements Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for(int num : nums) {
            if(num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }

        return Math.max(count, max);
    }

}
