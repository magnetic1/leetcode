/**
 * Leetcode - binary_prefix_divisible_by_5
 */
package com.leetcode.binary_prefix_divisible_by_5;
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

    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = A.length;
        Boolean[] ans = new Boolean[A.length];
        int a = 0;
        for(int i = 0; i < n; i++) {
            a = ((a << 1) + A[i]) % 5;
            ans[i] = (a == 0);
        }

        return Arrays.asList(ans);
    }

}
