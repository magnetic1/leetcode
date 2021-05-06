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
class Solution2 implements Solution {

    public boolean judgeSquareSum(int c) {
        long i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            long ss = i * i + j * j;
            if (ss == c) {
                return true;
            } else if (ss > c) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

}
