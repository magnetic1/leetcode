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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {
    public int romanToInt(String s) {
        int[] roman = {100,500,0,0,0,0,1,0,0,50,1000,0,0,0,0,0,0,0,0,5,0,10};

        int value = 0;
        int lastCharValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int charValue = roman[c - 67];
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
        Solution2 solution = new Solution2();

        System.out.println(solution.romanToInt("MCMXCIV"));
    }

}
