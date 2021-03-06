/**
 * Leetcode - next_greater_element_ii
 */
package com.leetcode.next_greater_element_ii;
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

    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] ans = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int count = 0, index = 0;

        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && count < n && nums[i] > nums[deque.peek()]) {
                ans[deque.pop()] = nums[i];
                count++;
            }
            deque.push(i);
            if(nums[i] == max) {
                ans[i] = -1;
                count++;
            }
        }
        int i = 0;
        while(count < n) {
            while(!deque.isEmpty() && count < n && nums[i] > nums[deque.peek()]) {
                ans[deque.pop()] = nums[i];
                count++;
            }
            i++;
        }

        return ans;
    }

}
