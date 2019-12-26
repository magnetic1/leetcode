/**
 * Leetcode - remove_duplicates_from_sorted_array
 */
package com.leetcode.remove_duplicates_from_sorted_array;
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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int ite = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ite != nums[i]) {
                ite = nums[i];
                nums[res++] = ite;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.removeDuplicates(new int[]{1, 1, 2}));
    }
}
