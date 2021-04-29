package com.leetcode.frog_jump;

import java.util.*;
import com.ciaoshen.leetcode.util.*;

public class Solution4 {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        if (n == 2) {
            return true;
        }

        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        boolean[][] dp = new boolean[n][n];
        dp[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int jump = stones[i] - stones[j];
                if (jump > j + 1) {
                    continue;
                }
                dp[i][jump] = dp[j][jump] || dp[j][jump - 1] || dp[j][jump + 1];
                if (i == n - 1 && dp[i][jump]) {
                    return true;
                }
            }
        }

        return false;
    }
}
