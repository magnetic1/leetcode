/**
 * Leetcode - divide_two_integers
 */
package com.leetcode.divide_two_integers;
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
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0;
        for (int x = 31; x >= 0; x--){
            if ((a >>> x) >= divisor) {
                res += 1 << x;
                a -= b << x;
            }
        }

        return (divisor > 0) == (dividend > 0) ? res : -res;
    }

}
