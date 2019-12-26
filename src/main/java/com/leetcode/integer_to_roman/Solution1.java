/**
 * Leetcode - integer_to_roman
 */
package com.leetcode.integer_to_roman;

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

    public String intToRoman(int num) {
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] M = {"", "M", "MM", "MMM"};

        return M[(num / 1000) % 10] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.intToRoman(1994));

    }

}
