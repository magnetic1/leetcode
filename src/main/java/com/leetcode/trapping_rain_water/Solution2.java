/**
 * Leetcode - trapping_rain_water
 */
package com.leetcode.trapping_rain_water;
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

    public int trap(int[] height){
        if (height.length == 0) {
            return 0;
        }

        int volumn = 0;

        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            volumn += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return volumn;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
