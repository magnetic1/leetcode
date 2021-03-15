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
class Solution2 implements Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int len = n * m;
        List<Integer> ans = new ArrayList<>(len);

        int[][] directions = new int[][] {
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int[] routes = new int[] {m, n};
        int direction = 0, runed = 0;
        int x = 0, y = -1;
        for(int i = 0; i < len; i++) {
            x += directions[direction][0];
            y += directions[direction][1];
            ans.add(matrix[x][y]);

            runed++;
            if (runed == routes[1 - direction % 2]) {
                routes[direction % 2]--;
                runed = 0;
                direction = (direction + 1) % 4;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.spiralOrder(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        });
    }

}
