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
class Solution1 implements Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1 || numRows == 1) {
            return s;
        }

        List<List<Character>> charLists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            charLists.add(new ArrayList<>());
        }
        boolean isAdd = true;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            charLists.get(index).add(s.charAt(i));
            if (isAdd) {
                index++;
            } else {
                index--;
            }
            if (index == 0 || index == numRows - 1) {
                isAdd = !isAdd;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (char c : charLists.get(i)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.convert("AB",1));
    }

}
