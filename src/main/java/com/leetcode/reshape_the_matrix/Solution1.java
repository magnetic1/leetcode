/**
 * Leetcode - reshape_the_matrix
 */
package com.leetcode.reshape_the_matrix;
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

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if(m * n == r * c) {
            int[][] ans = new int[r][c];
            int row = 0, col = 0;
            for (int[] num : nums) {
                for (int j = 0; j < n; j++) {
                    if (col == c) {
                        row++;
                        col = 0;
                    }
                    ans[row][col] = num[j];
                    col++;
                }
            }

            return ans;
        }

        return nums;
    }

}
