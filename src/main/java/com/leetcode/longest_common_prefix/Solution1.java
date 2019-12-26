/**
 * Leetcode - longest_common_prefix
 */
package com.leetcode.longest_common_prefix;
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

    public String longestCommonPrefix(String[] strs) {
        int num = strs.length;
        if (num <= 0) {
            return "";
        }

        int max = Integer.MAX_VALUE;
        for (String str : strs) {
            max = max < str.length() - 1 ? max : str.length() - 1;
        }

        StringBuilder prefix = new StringBuilder();
        int index = 0;
        boolean hasNext = true;

        while (hasNext && index <= max) {
            char c = strs[0].charAt(index);

            for (String str : strs) {
                if (c != str.charAt(index)) {
                    hasNext = false;
                    break;
                }
            }

            if (hasNext) {
                prefix.append(c);
            }

            index++;
        }

        return prefix.toString();
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
