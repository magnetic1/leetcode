/**
 * Leetcode - valid_number
 */
package com.leetcode.valid_number;
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

// 没有用显示的矩阵表示状态机
class Solution2 implements Solution {

    public boolean isNumber(String s) {
        if (s.length() == 0) return false;

        s = s.trim();
        int n = s.length();

        if (n == 0) return false;

        boolean hasNumber = false;
        boolean hasE = false;
        boolean hasPoint = false;
        int signCount = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (!isValid(c)) return false;

            if (c >= '0' && c <= '9') hasNumber = true;

            if (c == '.') {
                if (hasPoint || hasE) return false;
                if (i == n - 1 && !hasNumber) return false;
                hasPoint = true;
            }

            if (c == 'e' || c == 'E') {
                if (hasE || !hasNumber) return false;
                if (i == n - 1) return false;
                hasE = true;
            }

            // signs
            if (c == '+' || c == '-') {
                // no more than 2 signs
                if (signCount == 2) return false;
                // sign cannot be the last one
                if (i == n - 1) return false;
                // sign can appear in the middle only when e appears in front
                if (i > 0 && !hasE) return false;

                signCount++;
            }
        }

        return true;
    }

    boolean isValid(char c) {
        return c == '.' || c == '+' || c == '-' ||
                c == 'e' || c == 'E' || c >= '0' && c <= '9';
    }

}
