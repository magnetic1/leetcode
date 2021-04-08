/**
 * Leetcode - find_minimum_in_rotated_sorted_array
 */
package com.leetcode.find_minimum_in_rotated_sorted_array;
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

    public int findMin(int[] nums) {
        int i = findMax(nums, 0, nums.length - 1);
        return nums[(i + 1) % nums.length];
    }

    int findMax(int[] nums, int left, int right) {
        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (nums[left] > nums[mid]) {
                right = mid - 1;
            } else if (nums[right] < nums[mid]) {
                left = mid;
            } else if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                right--;
            } else {
                return right;
            }
        }

        return left;
    }

}
