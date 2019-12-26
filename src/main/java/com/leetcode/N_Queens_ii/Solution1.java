/**
 * Leetcode - N_Queens_ii
 */
package com.leetcode.N_Queens_ii;

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
//    private char[][] nQueens;

    int ret = 0;
    int N;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;

    public int totalNQueens(int n) {
        N = n;
        colUsed = new boolean[n];
        diagonals45Used = new boolean[2 * n - 1];
        diagonals135Used = new boolean[2 * n - 1];
        dfs(0);

        return ret;
    }

    private void dfs(int r) {
        if (r == N) {
            ret++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check(r, i)) {
                colUsed[i] = true;
                diagonals45Used[r + i] = true;
                diagonals135Used[r - i + N - 1] = true;
                dfs(r + 1);
                colUsed[i] = false;
                diagonals45Used[r + i] = false;
                diagonals135Used[r - i + N - 1] = false;
            }
        }
    }

    private boolean check(int r, int i) {
        if (colUsed[i] || diagonals45Used[r + i] || diagonals135Used[r - i + N - 1]) {
            return false;
        }
        return true;
    }

}
