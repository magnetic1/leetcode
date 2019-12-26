/**
 * Leetcode - Reverse_Integer
 */
package com.leetcode.Reverse_Integer;
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

    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
        x = -x;
        isNegative = true;
    }
    String s = Integer.toString(x);
    long y = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        y = y * 10 + s.charAt(i) - 48;
    }
        if (!isNegative && y > Integer.MAX_VALUE) {
        return 0;
    }
        if (isNegative && y > (long)Integer.MAX_VALUE + 1) {
        return 0;
    }
        return isNegative ? (int)-y : (int)y;
}

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reverse(-1230));
    }

}
