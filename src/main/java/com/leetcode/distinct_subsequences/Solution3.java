package com.leetcode.distinct_subsequences;

public class Solution3 {

    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int n = t.length();
        int m = s.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];

        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;

        for (int i = 1; i < m; i++) {
            char sChar = s.charAt(i);
            dp[i][0] = sChar == t.charAt(0) ? dp[i - 1][0] + 1 : dp[i - 1][0];

            for (int j = 1; j < n && j <= i; j++) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
