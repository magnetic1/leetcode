/**
 * Leetcode - longest_consecutive_sequence
 */
package com.leetcode.longest_consecutive_sequence;

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

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for(int num : nums) {
            int right = num;
            int left = num;
            if(leftMap.containsKey(num + 1)) {
                right = leftMap.remove(num + 1);
            }

            if(rightMap.containsKey(num - 1)) {
                left = rightMap.remove(num - 1);
            }

            leftMap.put(left, Math.max(right, leftMap.getOrDefault(left, left)));
            rightMap.put(right, Math.min(left, rightMap.getOrDefault(right, right)));
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry : leftMap.entrySet()) {
            max = Math.max(max, entry.getValue() - entry.getKey() + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.longestConsecutive(new int[]{
                -7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7
        });
    }
}
