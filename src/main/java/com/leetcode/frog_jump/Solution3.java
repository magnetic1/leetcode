package com.leetcode.frog_jump;

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
public class Solution3 {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        if (n == 2) {
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
            map.put(stones[i], i);
        }

        int[][] dp = new int[n][n];
        dp[1][0] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int from = 0; from < i; from++) {
                if (dp[i][from] == 0) {
                    continue;
                }
                int len = stones[i] - stones[from];
                for (int k = 0; k < 3; k++) {
                    int jump = len + k - 1;
                    if (map.containsKey(stones[i] + jump)) {
                        int to = map.get(stones[i] + jump);
                        if (to == n - 1) {
                            return true;
                        }
                        dp[to][i] = 1;
                    }
                }
            }
        }

        return false;
    }
}
