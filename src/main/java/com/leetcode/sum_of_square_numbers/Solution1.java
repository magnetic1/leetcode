/**
 * Leetcode - sum_of_square_numbers
 */
package com.leetcode.sum_of_square_numbers;
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

    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);

        for (int i = 0; i <= n; i++) {
            int b2 = c - i * i;
            int b = (int) Math.sqrt(b2);
            if (b * b == b2) {
                return true;
            }
        }

        return false;
    }

}
