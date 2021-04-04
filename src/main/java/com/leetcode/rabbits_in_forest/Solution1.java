/**
 * Leetcode - rabbits_in_forest
 */
package com.leetcode.rabbits_in_forest;
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

    public int numRabbits(int[] answers) {
        int[] nums = new int[1000];

        for (int answer : answers) {
            nums[answer]++;
        }

        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            int num = nums[i];
            if (num > 0) {
                ans += (1 + (num - 1) / (i + 1)) * (i + 1);
            }
        }

        return ans;
    }

}
