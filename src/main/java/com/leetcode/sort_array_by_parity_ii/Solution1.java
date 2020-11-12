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
class Solution1 implements Solution {

    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int length = A.length;
        while (odd < A.length) {
            while (even < length && A[even] % 2 == 0) {
                even += 2;
            }
            while (odd < length && A[odd] % 2 == 1) {
                odd += 2;
            }

            if (even < length && odd < length) {
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
        }

        return A;
    }

}
