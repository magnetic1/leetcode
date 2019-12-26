/**
 * Leetcode - remove_element
 */
package com.leetcode.remove_element;
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
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length - 1;
        for (int i = 0; i <= length; i++) {
            while (nums[i] == val && length >= i) {
                nums[i] = nums[length--];
            }
        }

        return length + 1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.removeElement(new int[]{1, 2}, 1));

    }
}
