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
class Solution1 implements Solution {

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length, left = 0, right = 0;
        while(right < n) {
            int numRight = nums[right];
            map.put(numRight, map.getOrDefault(numRight, 0) + 1);
            if(map.lastKey() - map.firstKey() > limit) {
                int numLeft = nums[left];
                int count = map.get(numLeft);
                if(count == 1) {
                    map.remove(numLeft);
                } else {
                    map.put(numLeft, count - 1);
                }
                left++;
            }
            right++;
        }

        return right - left;
    }

}
