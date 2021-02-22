/**
 * Leetcode - longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit
 */
package com.leetcode.longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit;
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

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> queMin = new LinkedList<>();
        Deque<Integer> queMax = new LinkedList<>();
        int left = 0, right = 0, n = nums.length;

        while(right < n) {
            int num = nums[right];
            while(!queMax.isEmpty() && queMax.peek() < num) {
                queMax.pop();
            }
            queMax.push(num);
            while(!queMin.isEmpty() && queMin.peek() > num) {
                queMin.pop();
            }
            queMin.push(num);

            if(queMax.getLast() - queMin.getLast() > limit) {
                if(queMax.getLast() == nums[left]) {
                    queMax.pollLast();
                }
                if(queMin.getLast() == nums[left]) {
                    queMin.pollLast();
                }
                left++;
            }
            right++;
        }

        return right - left;
    }

}
