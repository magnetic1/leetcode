/**
 * Leetcode - search_in_rotated_sorted_array_ii
 */
package com.leetcode.search_in_rotated_sorted_array_ii;
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

    public boolean search(int[] nums, int target) {
        int i = findMax(nums, 0, nums.length - 1);

        return find(nums, 0, i, target) || find(nums, i + 1, nums.length - 1, target);
    }

    boolean find(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    int findMax(int[] nums, int left, int right) {
        while(left < right) {
            int mid = (left + right + 1) / 2;

            if(nums[left] > nums[mid]) {
                right = mid - 1;
            } else if(nums[right] < nums[mid]) {
                left = mid;
            } else if(nums[left] == nums[mid] && nums[right] == nums[mid]) {
                right--;
            } else {
                return right;
            }
        }

        return left;
    }

}
