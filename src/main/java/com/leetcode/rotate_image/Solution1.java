/**
 * Leetcode - rotate_image
 */
package com.leetcode.rotate_image;

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
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int m = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j && i + j < n - 1; i++) {
                int i1 , j1, tmp;

//                System.out.println(i + ", " + j);

                i1 = j;
                j1 = n - 1 - i;
                tmp = matrix[i1][j1];
                matrix[i1][j1] = matrix[i][j];
                matrix[i][j] = tmp;

//                System.out.println(i1 + ", " + j1);

                i1 = n - 1 - i;
                j1 = n - 1 - j;
                tmp = matrix[i1][j1];
                matrix[i1][j1] = matrix[i][j];
                matrix[i][j] = tmp;

//                System.out.println(i1 + ", " + j1);

                i1 = n - 1 - j;
                j1 = i;
                tmp = matrix[i1][j1];
                matrix[i1][j1] = matrix[i][j];
                matrix[i][j] = tmp;

//                System.out.println(i1 + ", " + j1 + "\n");

                matrix[i][j] = tmp;
            }
        }

    }

    private void swap(int[][] matrix, int i, int j, int i1, int j1) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = tmp;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution.rotate(a);

        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.print("\n");
        }


    }
}
