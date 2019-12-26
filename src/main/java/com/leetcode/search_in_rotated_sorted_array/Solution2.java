/**
 * Leetcode - search_in_rotated_sorted_array
 */
package com.leetcode.search_in_rotated_sorted_array;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && nums[mid] >= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                if (nums[high] >= target && nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.search(new int[]{4, 1, 4, 4, 4, 4, 4, 4, 4, 4}, 1));

    }

}
