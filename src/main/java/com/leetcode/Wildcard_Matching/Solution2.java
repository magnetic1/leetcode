/**
 * Leetcode - Wildcard_Matching
 */
package com.leetcode.Wildcard_Matching;
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

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, last_i = -1, last_j = -1;
        while (i < s.length()) {

            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                last_j = j;
                last_i = i;
                j++;
            } else if (last_j != -1) {
                j = last_j + 1;
                i = last_i;
                last_i++;
            } else return false;
        }

        for (; j < p.length(); j++) {
            if (p.charAt(j) != '*') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isMatch(
                "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb" ,
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }

}
