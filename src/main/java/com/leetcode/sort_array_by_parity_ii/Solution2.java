/**
 * Leetcode - sort_array_by_parity_ii
 */
package com.leetcode.sort_array_by_parity_ii;
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

    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        while (even < A.length) {
            if (A[even] % 2 == 1) {
                while (A[odd] % 2 == 1) {
                    odd += 2;
                }
                int temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
            }
            even += 2;
        }

        return A;
    }

}
