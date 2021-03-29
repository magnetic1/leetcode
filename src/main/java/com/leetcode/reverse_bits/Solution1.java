/**
 * Leetcode - reverse_bits
 */
package com.leetcode.reverse_bits;
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

    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }

        return res;
    }

}
