/**
 * Leetcode - search_insert_position
 */
package com.leetcode.search_insert_position;
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

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = -1;

        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (nums[low] < target) {
            return low + 1;
        } else {
            return low;
        }

    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int i = solution.searchInsert(new int[]{1, 3, 5, 5, 6}, 4);
        System.out.println(i);
    }
}
