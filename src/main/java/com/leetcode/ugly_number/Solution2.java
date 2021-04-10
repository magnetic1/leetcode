/**
 * Leetcode - ugly_number
 */
package com.leetcode.ugly_number;
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

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n /= num;
            }
        }

        return n == 1;
    }

}
