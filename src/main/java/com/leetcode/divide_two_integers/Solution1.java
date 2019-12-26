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
class Solution1 implements Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend /  divisor;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        System.out.println(-2 >>> 1);
    }
}
