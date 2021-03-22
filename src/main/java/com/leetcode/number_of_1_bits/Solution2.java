/**
 * Leetcode - number_of_1_bits
 */
package com.leetcode.number_of_1_bits;
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

    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) {
                ans++;
            }
        }

        return ans;
    }

}
