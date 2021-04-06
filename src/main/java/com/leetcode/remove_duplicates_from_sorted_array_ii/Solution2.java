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
class Solution2 implements Solution {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        int j = 2;
        for (int i = 2; i < n; i++) {
            if (nums[j - 2] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

}
