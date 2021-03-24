/**
 * Leetcode - 132_pattern
 */
package com.leetcode.pattern_132;
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

    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        Stack<Integer> deque = new Stack<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (k > nums[i]) {
                return true;
            }
            while (!deque.isEmpty() && deque.peek() < nums[i]) {
                k = Math.max(k, deque.pop());
            }
            deque.push(nums[i]);
        }

        return false;

    }

}
