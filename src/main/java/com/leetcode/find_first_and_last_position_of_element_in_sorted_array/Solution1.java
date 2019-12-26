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
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int first = -1, last = -1;
        int low = 0, high = length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                int pre = mid - 1;
                if (pre < 0 || nums[pre] != target) {
                    first = mid;
                    break;
                } else {
                    high = pre;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (first == -1) {
            return new int[]{-1, -1};
        }

        low = 0;
        high = length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                int next = mid + 1;
                if (next >= length || nums[next] != target) {
                    last = mid;
                    break;
                } else {
                    low = next;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{first, last};

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] re = solution1.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(re[0] + ", " + re[1]);
    }

}
