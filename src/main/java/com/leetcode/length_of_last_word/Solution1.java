/**
 * Leetcode - length_of_last_word
 */
package com.leetcode.length_of_last_word;
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

    public int lengthOfLastWord(String s) {
        int index = s.length() -1;

        // find last character
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        // get the length of the word
        int res = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}
