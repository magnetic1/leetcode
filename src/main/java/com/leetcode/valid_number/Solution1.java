/**
 * Leetcode - valid_number
 */
package com.leetcode.valid_number;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */

class Solution1 implements Solution {
    public boolean isNumber(String s) {
        // 1.空 2.正负号 3.数 4.小数点 5.e 6.指数 7.结束
        // 1.数 2.正负号 3.e 4.小数点 5.空格 6.other

        int[][] p = {
                {2, 1, -1, 3, 0, -1},
                {2, -1, -1, 3, -1, -1},
                {2, -1, 4, 7, 6, -1},
                {7, -1, -1, -1, -1, -1},
                {5, 8, -1, -1, -1, -1},
                {5, -1, -1, -1, 6, -1},
                {-1, -1, -1, -1, 6, -1},
                {7, -1, 4, -1, 6, -1},
                {5, -1, -1, -1, -1, -1},
        };

        int state = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int column = getColumn(c);

            int n = p[state][column];
            if (n < 0) {
                return false;
            }
            state = n;
        }
        return state == 2 || state == 5 || state == 6 || state == 7;
    }

    int getColumn(char c) {
        if ('0' <= c && c <= '9') {
            return 0;
        } else if (c == '-' || c == '+') {
            return 1;
        } else if (c == 'e') {
            return 2;
        } else if (c == '.') {
            return 3;
        } else if (c == ' ') {
            return 4;
        } else {
            return 5;
        }
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.isNumber("53.5e93"));
    }

}
