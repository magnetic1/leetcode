/**
 * Leetcode - ugly_number_ii
 */
package com.leetcode.ugly_number_ii;
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

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        int p2 = 1, p3 = 1, p5 = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;

            int num = Math.min(num2, Math.min(num3, num5));
            dp[i] = num;
            if (num == num2) {
                p2++;
            }
            if (num == num3) {
                p3++;
            }
            if (num == num5) {
                p5++;
            }
        }

        return dp[n];
    }

}
