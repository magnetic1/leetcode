/**
 * Leetcode - ZigZag_Conversion
 */
package com.leetcode.ZigZag_Conversion;
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
@SuppressWarnings("WeakerAccess")
class Solution2 implements Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1 || numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i >= s.length()) {
                break;
            }
            int index = i;
            int num = 1;
            while (index < s.length()) {
                stringBuilder.append(s.charAt(index));
                index = updateIndex(i, num, index, numRows);
                num++;
            }
        }
        return stringBuilder.toString();
    }

    private int updateIndex(int i, int num, int index, int numRows) {
        int gap = 2 * (numRows - 1);
        if (i == 0 || i == numRows - 1) {
            return index + gap;
        }
        if (num % 2 == 1) {
            index = index + gap - 2 * i;
        } else {
            index = index + 2 * i;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.convert("PAYPALISHIRING",3));
    }

}
