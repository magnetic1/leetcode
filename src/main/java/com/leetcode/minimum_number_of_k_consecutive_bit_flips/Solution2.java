/**
 * Leetcode - minimum_number_of_k_consecutive_bit_flips
 */
package com.leetcode.minimum_number_of_k_consecutive_bit_flips;
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

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int ans = 0, count = 0;
        int[] diff = new int[n + 1];
        for(int i = 0; i < n; i++) {
            count += diff[i];

            if((A[i] + count) % 2 == 0) {
                if(i + K > n) {
                    return -1;
                }
                count++;
                ans++;
                diff[i + K]--;
            }
        }

        return ans;
    }

}
