/**
 * Leetcode - climbing_stairs
 */
package com.leetcode.climbing_stairs;
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
    int a[];

    public int climbStairs(int n) {
        a = new int [n + 1];
        return climb(n);
    }

    int climb(int n) {
        if(n <= 0){
            return 0;
        }
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }

        if(a[n - 1] == 0) {
            a[n - 1] = climb(n-1);
        }
        if(a[n - 2] == 0) {
            a[n - 2] = climb(n-2);
        }

        return a[n - 1] + a[n - 2];
    }

}
