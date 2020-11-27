/**
 * Leetcode - four_sum_ii
 */
package com.leetcode.four_sum_ii;
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

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A) {
            for(int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        int res = 0;
        for(int c : C) {
            for(int d : D) {
                int v = c + d;
                if(map.containsKey(-v)) {
                    res += map.get(-v);
                }
            }
        }

        return res;
    }

}
