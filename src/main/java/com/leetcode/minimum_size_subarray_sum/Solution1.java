/**
 * Leetcode - minimum_size_subarray_sum
 */
package com.leetcode.minimum_size_subarray_sum;

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
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0, l = 0, r = 0, len = Integer.MAX_VALUE;

        while (r < nums.length && l <= r) {
            if (sum >= s) {
                len = Math.min(len, r - l);
                sum -= nums[l];
                l++;
            } else {
                sum += nums[r];
                r++;
            }
        }

        while (l < r) {
            if (sum >= s) {
                len = Math.min(len, r - l);
                sum -= nums[l];
                l++;
            } else {
                break;
            }
        }

        if (len == Integer.MAX_VALUE) {
            return 0;
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
