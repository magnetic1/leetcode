/**
 * Leetcode - how_many_numbers_are_smaller_than_the_current_number
 */
package com.leetcode.how_many_numbers_are_smaller_than_the_current_number;
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

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] p = new int[n][2];

        for(int i = 0; i < n; i++) {
            p[i][0] = nums[i];
            p[i][1] = i;
        }

        Arrays.sort(p, (int[] p1, int[] p2) -> {
            return p1[0] - p2[0];
        });

        int[] ret = new int[n];
        ret[p[0][1]] = 0;
        for(int i = 1; i < n; i++) {
            if(p[i][0] == p[i - 1][0]) {
                ret[p[i][1]] = ret[p[i - 1][1]];
            } else {
                ret[p[i][1]] = i;
            }
        }

        return ret;
    }

}
