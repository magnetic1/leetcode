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
class Solution1 implements Solution {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (true) {
            if (n == 1) {
                return true;
            } else if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
    }

}
