/**
 * Leetcode - spiral_matrix
 */
package com.leetcode.spiral_matrix;

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
    int m;
    int n;
    int direction = 0;
    boolean[][] marked;

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        m = matrix.length;
        n = matrix[0].length;
        direction = 0;
        marked = new boolean[m][n];

        List<Integer> ret = new ArrayList<>();

        int i = 0, j = 0;
        for (int k = 0; k < m * n; k++) {

            marked[i][j] = true;
            ret.add(matrix[i][j]);


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

        return ret;
    }

    private boolean isBump(int i, int j) {
        if (direction == 0 && (j == n - 1 || marked[i][j + 1])) {
            return true;
        } else if (direction == 1 && (i == m - 1 || marked[i + 1][j])) {
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
        System.out.println(solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }


}
