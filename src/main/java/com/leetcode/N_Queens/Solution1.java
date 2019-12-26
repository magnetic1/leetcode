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
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    int col[] = new int[100];
    int d1[] = new int[100];
    int d2[] = new int[100];

    List<List<String>> l = new ArrayList();

    boolean check(int i, int j) {
        if (col[j] == 0 && d1[i + j] == 0 && d2[i - j + 40] == 0)
            return true;
        return false;
    }

    void solve(char arr[][], int idx, int no) {
        int n = arr.length;

        if (no == n) {
            List<String> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = new String(arr[i]);
                al.add(s);
            }
            l.add(al);
            return;
        }
        if (idx >= n) return;
        for (int j = 0; j < n; j++) {
            if (check(idx, j)) {
                col[j] = 1;
                d1[idx + j] = 1;
                d2[idx - j + 40] = 1;
                arr[idx][j] = 'Q';
                solve(arr, idx + 1, no + 1);
                arr[idx][j] = '.';
                col[j] = 0;
                d1[idx + j] = 0;
                d2[idx - j + 40] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return l;
        char arr[][] = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(arr[i], '.');

        solve(arr, 0, 0);

        return l;
    }

}
