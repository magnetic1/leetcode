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
class Solution2 implements Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;

        str = str.trim();

        if (str.length() == 0) return 0;

        char[] chArray = str.toCharArray();
        int sign = 1;
        int i = 0;
        if (chArray[0] == '+') {
            sign = 1;
            i++;
        } else if (chArray[0] == '-') {
            sign = -1;
            i++;
        }

        int result = 0;
        while (i < chArray.length) {
            int digit = chArray[i] - '0';
            if (digit < 0 || digit > 9) {
                return sign * result;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.myAtoi("-2147483648"));
    }
}
