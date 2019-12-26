/**
 * Leetcode - powx_n
 */
package com.leetcode.powx_n;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            return (n % 2 == 0) ? myPow(x * x, -(n / 2)) : x * myPow(x * x, -(n / 2));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }


}
