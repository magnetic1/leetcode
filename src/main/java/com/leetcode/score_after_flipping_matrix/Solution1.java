/**
 * Leetcode - score_after_flipping_matrix
 */
package com.leetcode.score_after_flipping_matrix;
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

    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for(int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for(int j = 1; j < n; j++) {
            int ones = 0;
            for(int i = 0; i < m; i++) {
                if(A[i][j] == 1) {
                    ones++;
                }
            }
            ret += Math.max(ones, m - ones) * (1 << (n - j - 1));
        }

        return ret;
    }

}
