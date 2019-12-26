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
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int volumn = 0, index = 0;

        while (index < height.length) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int distance = index - stack.peek() - 1;
                int h = Math.min(height[index], height[stack.peek()]) - height[top];

                volumn += distance * h;
            }

            stack.push(index);
            index++;
        }
        return volumn;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }


}
