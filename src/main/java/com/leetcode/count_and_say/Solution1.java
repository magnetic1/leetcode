/**
 * Leetcode - count_and_say
 */
package com.leetcode.count_and_say;

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
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();

        int count = 1;
        char lastValue = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char v = s.charAt(i);
            if (lastValue == v) {
                count++;
            } else {
                stringBuilder.append(count).append(lastValue);
                lastValue = v;
                count = 1;
            }
        }

        stringBuilder.append(count).append(lastValue);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.countAndSay(6));
    }

}
