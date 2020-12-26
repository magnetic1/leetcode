/**
 * Leetcode - maximal_rectangle
 */
package com.leetcode.maximal_rectangle;
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

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == '1') {
                left[i][0] = 1;
            } else {
                left[i][0] = 0;
            }
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '1') {
                    left[i][j] = left[i][j - 1] + 1;
                } else {
                    left[i][j] = 0;
                }
            }
        }
        int ret = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(left[i][j] == 0) {
                    continue;
                }

                int height = 1;
                int width = left[i][j];
                ret = Math.max(ret, height * width);

                for (int k = i - 1; k >= 0; k--) {
                    height++;
                    width = Math.min(width, left[k][j]);
                    ret = Math.max(ret, height * width);
                }
            }
        }

        return ret;

    }

}
