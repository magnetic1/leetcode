/**
 * Leetcode - spiral_matrix
 */
package com.leetcode.spiral_matrix_ii;

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
    int direction = 0;
    boolean[][] marked;
    int n;

    public int[][] generateMatrix(int n) {
        this.n = n;
        marked = new boolean[n][n];

        int[][] res = new int[n][n];

        int i = 0, j = 0, num = 1;
        for (int k = 0; k < n * n; k++) {
            marked[i][j] = true;
            res[i][j] = num++;

            if (isBump(i, j)) {
                direction = (direction + 1) % 4;
            }

            if (direction == 0) {
                j++;
            } else if (direction == 1) {
                i++;
            } else if (direction == 2) {
                j--;
            } else {
                i--;
            }

        }


        return res;
    }


    private boolean isBump(int i, int j) {
        if (direction == 0 && (j == n - 1 || marked[i][j + 1])) {
            return true;
        } else if (direction == 1 && (i == n - 1 || marked[i + 1][j])) {
            return true;
        } else if (direction == 2 && (j == 0 || marked[i][j - 1])) {
            return true;
        } else if (direction == 3 && (i == 0 || marked[i - 1][j])) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }


}
