/**
 * Leetcode - N_Queens
 */
package com.leetcode.N_Queens;
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
class Solution2 implements Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diagonals1 = new boolean[2 * n];
        boolean[] diagonals2 = new boolean[2 * n];


        int[] sample = new int[n];

        search(0, n, sample, columns, diagonals1, diagonals2);

        return ans;
    }

    void search(int row, int n, int[] sample, boolean[] columns, boolean[] diagonals1, boolean[] diagonals2) {
        if (row == n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (sample[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (columns[col] || diagonals1[row - col + n] || diagonals2[row + col]) {
                continue;
            }
            sample[row] = col;

            columns[col] = true;
            diagonals1[row - col + n] = true;
            diagonals2[row + col] = true;

            search(row + 1, n, sample, columns, diagonals1, diagonals2);

            columns[col] = false;
            diagonals1[row - col + n] = false;
            diagonals2[row + col] = false;
        }
    }
}
