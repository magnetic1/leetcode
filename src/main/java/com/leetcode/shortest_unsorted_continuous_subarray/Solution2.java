/**
 * Leetcode - shortest_unsorted_continuous_subarray
 */
package com.leetcode.shortest_unsorted_continuous_subarray;
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

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();

        int left = n;
        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && nums[deque.peek()] > nums[i]) {
                left = Math.min(deque.pop(), left);
            }
            deque.push(i);
        }

        deque.clear();
        int right = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                right = Math.max(deque.pop(), right);
            }
            deque.push(i);
        }

        return right >= left ? right - left + 1 : 0;
    }

}
