/**
 * Leetcode - volume_of_histogram_lcci
 */
package com.leetcode.volume_of_histogram_lcci;
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

    public int trap(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }

        int left = 1, right = length - 2;
        int leftMax = height[0], rightMax = height[length - 1];

        int ans = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }

        return ans;

    }

}
