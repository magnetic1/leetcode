/**
 * Leetcode - move_zeroes
 */
package com.leetcode.move_zeroes;
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

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0, i = 0;

        while (i < n) {
            if(nums[i] == 0) {
                i++;
                break;
            }
            i++;
            j++;
        }
        for(; i < n; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while(j < n) {
            nums[j++] = 0;
        }
    }

}
