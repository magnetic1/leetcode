/**
 * Leetcode - reverse_pairs
 */
package com.leetcode.reverse_pairs;

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

    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    int reversePairs(int[] nums, int l, int r) {
        if(l >= r) {
            return 0;
        }

        int mid = (l + r) / 2;
        int pl = reversePairs(nums, l, mid);
        int pr = reversePairs(nums, mid + 1, r);

        Arrays.sort(nums, l, mid + 1);
        Arrays.sort(nums, mid + 1, r + 1);

        int p = 0;
        int l_ptr = l, r_ptr = mid + 1;
        while(l_ptr <= mid && r_ptr <= r) {
            if(nums[l_ptr] > 2 * (long) nums[r_ptr]) {
                p += mid - l_ptr + 1;
                r_ptr++;
            } else {
                l_ptr++;
            }
        }

        return pl + pr + p;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.reversePairs(new int[]{
                2, 4, 3, 5, 1
        });
    }

}
