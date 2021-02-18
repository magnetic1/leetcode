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
class Solution1 implements Solution {

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int i = 0, ans = 0;
        for(; i <= n - K; i++) {
            if(A[i] == 0) {
                ans++;
                flip(A, K, i);
            }
        }

        while(i < n) {
            if(A[i] == 0) {
                return -1;
            }
            i++;
        }

        return ans;
    }

    void flip(int[] A, int K, int i) {
        for(int k = 0; k < K; k++) {
            int index = i + k;
            A[index] = A[index] ^ 1;
        }
    }

}
