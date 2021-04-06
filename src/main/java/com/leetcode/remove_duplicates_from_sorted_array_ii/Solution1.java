/**
 * Leetcode - remove_duplicates_from_sorted_array_ii
 */
package com.leetcode.remove_duplicates_from_sorted_array_ii;
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
        int count = 0, n = nums.length;
        int i = 0, j = 0, value = 100000;

        while (i < n) {
            if (value != nums[i]) {
                value = nums[i];
                count = 1;
                nums[j] = nums[i];
                j++;
            } else if (count < 2) {
                nums[j] = nums[i];
                count++;
                j++;
            }

            i++;
        }

        return j;
    }

}
