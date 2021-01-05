/**
 * Leetcode - positions_of_large_groups
 */
package com.leetcode.positions_of_large_groups;
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


    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<List<Integer>> ret = new ArrayList<>();

        int num = 0;
        char last = '0';
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == last) {
                num++;
            } else {
                if(num >= 3) {
                    ret.add(Arrays.asList(i - num, i - 1));
                }
                num = 1;
                last = c;
            }
        }

        if(num >= 3) {
            ret.add(Arrays.asList(n - num, n - 1));
        }
        return ret;
    }
}
