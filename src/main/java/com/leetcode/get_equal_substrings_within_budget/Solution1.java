/**
 * Leetcode - get_equal_substrings_within_budget
 */
package com.leetcode.get_equal_substrings_within_budget;
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

    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0, left = 0, right = 0;
        int n = s.length();
        char [] sch  = s.toCharArray();
        char [] tch = t.toCharArray();
        while(right < n) {
            cost += Math.abs(sch[right] - tch[right]);
            if(cost > maxCost) {
                cost -= Math.abs(sch[left] - tch[left]);
                left++;
            }
            right++;
        }

        return right - left;
    }

}
