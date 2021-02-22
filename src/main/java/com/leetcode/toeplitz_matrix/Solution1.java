/**
 * Leetcode - toeplitz_matrix
 */
package com.leetcode.toeplitz_matrix;
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

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int i = 0, j = n - 1;
        while(i < m && j < n) {
            int x = i, y = j;
            int value = matrix[x][y];
            x++; y++;
            while(x < m && y < n) {
                if(matrix[x][y] != value) {
                    return false;
                }
                x++; y++;
            }

            if(j == 0) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        return true;
    }

}
