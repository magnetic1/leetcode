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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] a = new int[m], c = new int[m + n];

        // reverse the first number
        for (int i = 0; i < m; i++) {
            a[m - 1 - i] = num1.charAt(i) - '0';
        }

        int zero = 0;
        for (int i = n - 1; i >= 0; i--) {
            add(c, a, num2.charAt(i) - '0', zero++);
        }

        carry(c);

        int l = m + n;
        while (l > 0 && c[--l] == 0);

        StringBuilder stringBuilder = new StringBuilder();
        while (l >= 0) {
            stringBuilder.append(c[l--]);
        }

        return stringBuilder.toString();
    }

    private void carry(int[] c) {
        int v;
        for (int i = 0, carry = 0; i < c.length; i++) {
            v = c[i] + carry;
            c[i] = v % 10;
            carry = v / 10;
        }
    }

    private void add(int[] c, int[] a, int b, int zero) {
        for (int i = zero, j = 0; j < a.length; j++) {
            c[i++] += a[j] * b;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.multiply("123", "456"));
    }

}
