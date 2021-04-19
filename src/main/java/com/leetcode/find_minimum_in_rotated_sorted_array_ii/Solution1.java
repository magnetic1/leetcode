/**
 * Leetcode - find_minimum_in_rotated_sorted_array_ii
 */
package com.leetcode.find_minimum_in_rotated_sorted_array_ii;
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

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;

        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

}
