/**
 * Leetcode - container_with_most_water
 */
package com.leetcode.container_with_most_water;

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
    public int maxArea(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            water = Math.max(water, h * (right - left));
            while (left < right && height[left] <= h) left++;
            while (left < right && height[right] <= h) right--;
        }
        return water;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = solution2.maxArea(input);
        System.out.println(res);
    }

}
