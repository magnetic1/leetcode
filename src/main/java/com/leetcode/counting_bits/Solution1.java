/**
 * Leetcode - counting_bits
 */
package com.leetcode.counting_bits;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                ans[i] = ans[i / 2] + 1;
            } else {
                ans[i] = ans[i / 2];
            }
        }

        return ans;
    }

}
