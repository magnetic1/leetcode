/**
 * Leetcode - monotone_increasing_digits
 */
package com.leetcode.monotone_increasing_digits;
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

    public int monotoneIncreasingDigits(int N) {
        int ret = 0;
        int last = 10, exp = 1;
        while(N != 0) {
            int now = N % 10;
            if(now <= last) {
                ret += now * exp;
                last = now;
            } else {
                ret = now * exp - 1;
                last = now - 1;
            }
            N /= 10;
            exp *= 10;
        }

        return ret;
    }

}
