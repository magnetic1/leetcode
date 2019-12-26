/**
 * Leetcode - roman_to_integer
 */
package com.leetcode.roman_to_integer;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * roman[' log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int romanToInt(String s) {
        int[] roman = new int[256];
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        int value = 0;
        int lastCharValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int charValue = roman[c];
            if (charValue >= lastCharValue) {
                value += charValue;
            } else {
                value -= charValue;
            }
            lastCharValue = charValue;
        }

        return value;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.romanToInt("MCMXCIV"));
    }

}
