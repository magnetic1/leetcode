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
class Solution2 implements Solution {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a1, a2) -> {
            int v = a1[0] - a2[0];
            return v == 0 ? a2[1] - a1[1] : v;
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 1;
        dp[0] = envelopes[0][1];
        for(int i = 1; i < n; i++) {
            int num = envelopes[i][1];

            int index = binarySearch(dp, len, num);
            dp[index] = num;
            len = Math.max(len, index + 1);
        }
        return len;
    }

    int binarySearch(int[] dp, int len, int value) {
        int l = 0, r = len - 1, mid = (l + r) / 2;

        while(l <= r) {
            if(dp[mid] < value) {
                l = mid + 1;
            } else if(dp[mid] > value) {
                r = mid - 1;
            } else {
                return mid;
            }
            mid = (l + r) / 2;
        }
        return l;
    }

}
