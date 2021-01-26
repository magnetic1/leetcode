/**
 * Leetcode - number_of_equivalent_domino_pairs
 */
package com.leetcode.number_of_equivalent_domino_pairs;
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

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] nums = new int[100];
        int ans = 0;
        for (int[] domino : dominoes) {
            int a = domino[0], b = domino[1];
            int val = a < b ? a * 10 + b : b * 10 + a;
            ans += nums[val];
            nums[val]++;
        }

        return ans;
    }

}
