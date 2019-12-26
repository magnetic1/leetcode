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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int len = nums.length;
        int lo = 0, hi = len - 1;

        if (nums[hi] < target && nums[lo] > target) {
            return -1;
        }

        boolean pointIn = true;

        return search(nums, lo, hi, target, pointIn);


    }

    private int search(int[] nums, int lo, int hi, int target, boolean pointIn) {

        if (nums[lo] == target) {
            return lo;
        }
        if (nums[hi] == target) {
            return hi;
        }
        if (lo + 1 >= hi) {
            return -1;
        }
        // 顺序
        if (!pointIn) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                return search(nums, mid + 1, hi, target, false);
            } else {
                return search(nums, lo, mid - 1, target, false);
            }
        }

        // pointIn
        if (target > nums[lo] || target < nums[hi]) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > nums[lo]) {
                int left = search(nums, lo, mid, target, false);
                if (left >= 0) {
                    return left;
                }
                return search(nums, mid, hi, target, true);
            } else {
                int right = search(nums, mid, hi, target, false);
                if (right >= 0) {
                    return right;
                }
                return search(nums, lo, mid, target, true);
            }


        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.search(new int[]{4, 4, 4, 4, 4, 4, 4, 1, 4, 4}, 1));
    }

}
