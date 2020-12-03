/**
 * Leetcode - find_first_and_last_position_of_element_in_sorted_array
 */
package com.leetcode.find_first_and_last_position_of_element_in_sorted_array;
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

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {-1, -1};
        }
        int l = 0, r = nums.length - 1, mid = (l + r) / 2;

        while(l < r) {
            if (target == nums[mid]) {
                break;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (r + l) / 2;
        }

        if (nums[mid] != target) {
            return new int[] {-1, -1};
        }

        int first = searchFirst(nums, l, mid, target);
        int last = searchLast(nums, mid, r, target);

        return new int[] {first, last};
    }

    int searchFirst(int[] nums, int l, int r, int target) {
        int mid = (l + r - 1) / 2;
        while(l < r) {
            if(target == nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = (r + l - 1) / 2;
        }

        return r;
    }

    int searchLast(int[] nums, int l, int r, int target) {
        int mid = (l + r + 1) / 2;
        while(l < r) {
            if(target == nums[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
            mid = (r + l + 1) / 2;
        }

        return l;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    }

}
