/**
 * Leetcode - unique_paths
 */
package com.leetcode.unique_paths;
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

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        long a, b;
        if (m > n) {
            a = m - 1;
            b = n - 1;
        } else {
            a = n - 1;
            b = m - 1;
        }

        long res = 1;
        for (long i = 0; i < b; i++) {
            res = res * (a + i + 1);
        }

        for (long i = 0; i < b; i++) {
            res = res / (i + 1);
        }

        return (int)res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.uniquePaths(10, 10));
    }

}
