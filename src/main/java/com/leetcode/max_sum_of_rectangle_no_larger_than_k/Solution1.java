/**
 * Leetcode - max_sum_of_rectangle_no_larger_than_k
 */
package com.leetcode.max_sum_of_rectangle_no_larger_than_k;
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

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sums = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int i1 = i; i1 <= m; i1++) {
                    for (int j1 = j; j1 <= n; j1++) {
                        int sum = sums[i1][j1] + sums[i - 1][j - 1] - sums[i - 1][j1] - sums[i1][j - 1];
                        if (sum <= k) {
                            ans = Math.max(ans, sum);
                        }
                    }
                }
            }
        }

        return ans;
    }

}
