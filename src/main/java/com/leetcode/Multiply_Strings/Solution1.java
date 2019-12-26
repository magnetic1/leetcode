/**
 * Leetcode - Multiply_Strings
 */
package com.leetcode.Multiply_Strings;

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

    public String multiply(String num1, String num2) {

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String res = "0";

        for (int i = 0; i < num2.length(); i++) {
            int n = num2.charAt(num2.length() - 1 - i) - '0';

            String s = multiply(num1, n, i);

            res = add(res, s);

        }

        return res;
    }

    private String add(String num1, String num2) {
        int carry = 0;
        int length = Math.max(num1.length(), num2.length());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int v1 = num1.length() > i ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int v2 = num2.length() > i ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int v = v1 + v2 + carry;

            if (v > 9) {
                carry = 1;
                stringBuilder.append(v - 10);
            } else {
                carry = 0;
                stringBuilder.append(v);
            }
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    private String multiply(String num, int n, int m) {
        if (n == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < m; i++) {
            stringBuilder.append(0);
        }

        for (int i = 0; i < num.length(); i++) {
            int v = num.charAt(num.length() - 1 - i) - '0';

            v = v * n + carry;

            if (v > 9) {
                carry = v / 10;
                stringBuilder.append(v % 10);
            } else {
                carry = 0;
                stringBuilder.append(v);
            }
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.multiply("123", "456"));
    }
}
