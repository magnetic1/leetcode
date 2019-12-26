/**
 * Leetcode - string_to_integer_atoi
 */
package com.leetcode.string_to_integer_atoi;
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
    public int myAtoi(String str) {
        char c = ' ';
        int i;
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c != ' ') {
                break;
            }
        }

        boolean isNegetive = false;
        if (c == '-') {
            isNegetive = true;
            i++;
        } else if (c == '+') {
            i++;
        }
        int res = 0;
        i--;
        while (++i < str.length()) {
            c = str.charAt(i);
            if (c < 48 || c >= 58) {
                break;
            }
            if (isNegetive) {
                res = multiplyExact(res, 10);
                res = subtractExact(res, c - 48);
            } else {
                res = multiplyExact(res, 10);
                res = addExact(res, c - 48);
            }
            if (res == Integer.MAX_VALUE || res == Integer.MIN_VALUE) {
                return res;
            }
        }
        return res;
    }

    private static int addExact(int x, int y) {
        int r = x + y;

        if (((x ^ r) & (y ^ r)) < 0) {
            return Integer.MAX_VALUE;
        }
        return r;
    }

    private static int subtractExact(int x, int y) {
        int r = x - y;
        if (((x ^ y) & (x ^ r)) < 0) {
            return Integer.MIN_VALUE;
        }
        return r;
    }

    private static int multiplyExact(int x, int y) {
        int r = x * y;
        if ((r / y) != x) {
            if (x < 0) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.myAtoi("23424214124215"));
    }
}
