/**
 * Leetcode - degree_of_an_array
 */
package com.leetcode.degree_of_an_array;
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

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int max = 0, len = 50000, n = nums.length;

        for(int i = 0; i < n; i++) {
            int num = nums[i];

            int[] value;
            if(map.containsKey(num)) {
                value = map.get(num);
                value[0]++;
                value[2] = i;
            } else {
                value = new int[] {1, i, i};
                map.put(num, value);
            }

            if(max == value[0]) {
                len = Math.min(len, i - value[1] + 1);
            } else if(max < value[0]) {
                max = value[0];
                len = i - value[1] + 1;
            }
        }

        return len;
    }

}
