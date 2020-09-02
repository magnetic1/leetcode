/**
 * Leetcode - number_of_ways_to_reorder_array_to_get_same_bst
 */
package com.leetcode.number_of_ways_to_reorder_array_to_get_same_bst;

import java.util.*;
import java.util.stream.Collectors;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 *
 * f[l][r]代表l~r之间的数有多少种排列方案，预处理出g[l][r]代表l~r之间的数最靠前的一个是多少。
 * 设 a = g[l][r]，有转移 f[l][r] = f[l][a - 1] * f[a + 1][r] * C[r - l][a - l]
 */
class Solution1 implements Solution {
    int N = 1005;
    int[][] f = new int[N][N];
    int[][] g = new int[N][N];
    int[] pos = new int[N];
    int[][] C = new int[N][N];
    static int MO = (1_000_000_000 + 7);

    int n;
    List<Integer> a;

    public int numOfWays(int[] nums) {
        this.a = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.n = a.size();
        for (int i = 0; i < n; i++) {
            pos[a.get(i)] = i;
        }
        C[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MO;
            }
        }
        for (int l = 1; l <= n; l++) {
            int pp = n + 1;
            for (int r = l; r <= n; r++) {
                if (pos[r] < pp) {
                    pp = pos[r];
                }
                g[l][r] = pp;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = -1;
            }
        }
        int ans = dfs(1, n) - 1;
        ans %= MO;
        ans = (ans + MO) % MO;

        return ans;
    }

    private int dfs(int l, int r) {
        if (l >= r) {
            return 1;
        }
        if (f[l][r] != -1) {
            return f[l][r];
        }
        int first = a.get(g[l][r]);
        int n = r - l + 1, m = first - l;
        f[l][r] = (int) ((long) dfs(l, first - 1) * (long) dfs(first + 1, r) % (long) MO);
        f[l][r] = (int) ((long)f[l][r] * C[n - 1][m] % MO);
        return f[l][r];
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
