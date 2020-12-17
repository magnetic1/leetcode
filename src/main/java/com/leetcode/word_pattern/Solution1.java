/**
 * Leetcode - word_pattern
 */
package com.leetcode.word_pattern;
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

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();
        String[] strs = s.split(" ");

        if(pattern.length() != strs.length) {
            return false;
        }

        for(int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String str = strs[i];

            if(!charToStr.containsKey(c) && !strToChar.containsKey(str)) {
                charToStr.put(c, str);
                strToChar.put(str, c);
            } else if (!str.equals(charToStr.get(c)) || strToChar.get(str) != c) {
                return false;
            }
        }

        return true;
    }

}
