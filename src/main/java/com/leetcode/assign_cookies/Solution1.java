/**
 * Leetcode - assign_cookies
 */
package com.leetcode.assign_cookies;
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

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ret = 0;

        for(int si = 0, gi = 0; si < s.length && gi < g.length;) {
            if(s[si] >= g[gi]) {
                ret++;
                si++;
                gi++;
            } else {
                si++;
            }
        }

        return ret;
    }

}
