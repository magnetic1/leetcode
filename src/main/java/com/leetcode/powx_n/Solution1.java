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
class Solution1 implements Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            return 1 / myPow(x, Integer.MAX_VALUE) / x;
        }

        double[] doubles = new double[100];
        doubles[0] = x;

        double res = myPow(Math.abs(n), 0, doubles);

        if (n > 0) {
            return res;
        } else {
            return 1 / res;
        }

    }

    private double myPow(int n, int i, double[] doubles) {
        int j = i + 1;

        System.out.println(i);

        if (i > 30 || (1 << i) > n) {
            int next = n - (1 << i - 1);

            return doubles[i - 1] * myPow(next, 0, doubles);
        } else if ((1 << i) < n) {
            if (doubles[i] == 0) {
                doubles[i] = doubles[i - 1] * doubles[i - 1];
            }
            return myPow(n, j, doubles);
        } else {
            if (doubles[i] == 0) {
                doubles[i] = doubles[i - 1] * doubles[i - 1];
            }
            return doubles[i];
        }
    }


    public static void main(String[] args) {
//        System.out.println(4 << 1);
        Solution1 solution = new Solution1();
        System.out.println(solution.myPow(1, Integer.MAX_VALUE));

        System.out.println(Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE);
    }

}
