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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, h = height.length - 1;
        while (l < h) {
            int g = Math.min(height[l], height[h]);
            maxArea = Math.max(g * (h - l), maxArea);

            if (height[l] <= height[h]) {
                l++;
            } else {
                h--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = solution1.maxArea(input);
        System.out.println(res);
    }
}
