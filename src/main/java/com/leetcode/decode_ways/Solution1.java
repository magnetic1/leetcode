/**
 * Leetcode - decode_ways
 */
package com.leetcode.decode_ways;
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

    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        if(n == 0) {
            return 1;
        }

        int[] p = new int[n + 1];
        if(verify(s.charAt(0))) {
            p[1] = 1;
        }
        p[0] = 1;

        for(int i = 1; i < n; i++) {
            boolean b1 = verify(s.charAt(i));
            boolean b2 = verify(s.charAt(i - 1), s.charAt(i));
            if(b1 && b2) {
                p[i + 1] = p[i] + p[i - 1];
            } else if(b1) {
                p[i + 1] = p[i];
            } else if(b2) {
                p[i + 1] = p[i - 1];
            } else {
                p[i + 1] = 0;
            }
        }

        return p[n];
    }

    boolean verify(char c) {
        return c >= '1' && c <= '9';
    }

    boolean verify(char c1, char c2) {
        int v = (c1 - '0') * 10 + c2 - '0';
        return v <= 26 && v >= 10;
    }

}
