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
class Solution1 implements Solution {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], nums[i - 1]);
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() < nums[i]) {
                if (left[i] < deque.pop()) {
                    return true;
                }
            }
            deque.push(nums[i]);
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
