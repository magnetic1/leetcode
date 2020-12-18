/**
 * Leetcode - find_the_difference
 */
package com.leetcode.find_the_difference;
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

    public char findTheDifference(String s, String t) {
        int[] charNum = new int[26];

        charNum[t.charAt(0) - 'a']++;
        for(int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i) - 'a']--;
            charNum[t.charAt(i + 1) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(charNum[i] != 0) {
                return (char)(i + 'a');
            }
        }

        return 'a';
    }

}
