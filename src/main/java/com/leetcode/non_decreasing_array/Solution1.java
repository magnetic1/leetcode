/**
 * Leetcode - non_decreasing_array
 */
package com.leetcode.non_decreasing_array;
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

    public boolean checkPossibility(int[] nums) {
        int i = checkIgnore(nums, 0, 0);
        return i < 2;
    }

    int checkIgnore(int[] nums, int i, int ignored) {
        int n = nums.length;
        if(ignored >= 2) {
            return ignored;
        }

        while(i < n - 1) {
            if(nums[i] <= nums[i + 1]) {
                i++;
            } else if(ignored == 0) {
                if(i == 0 || nums[i - 1] <= nums[i + 1]) {
                    int i1 = checkIgnore(nums, i + 1, 1);
                    if(i1 < 2) {
                        return i1;
                    }
                }

                if(i == n - 2 || nums[i] <= nums[i + 2]) {
                    return checkIgnore(nums, i + 2, 1);
                }
                return 2;
            } else {
                return 2;
            }
        }

        return ignored;
    }

}
