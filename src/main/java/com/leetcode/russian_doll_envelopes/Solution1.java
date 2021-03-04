/**
 * Leetcode - russian_doll_envelopes
 */
package com.leetcode.russian_doll_envelopes;
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
class Solution1 implements Solution {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a1, a2) -> {
            int v = a1[0] - a2[0];
            return v == 0 ? a1[1] - a2[1] : v;
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }

}
