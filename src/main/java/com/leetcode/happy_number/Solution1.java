/**
 * Leetcode - happy_number
 */
package com.leetcode.happy_number;
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

    Map<Integer, Integer> map = new HashMap<>();
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }

        if(map.containsKey(n)) {
            return false;
        }
        map.put(n, 1);

        int newN = 0;
        do {
            int t = n % 10;
            newN += t * t;
            n = n / 10;
        } while(n > 0);

        return isHappy(newN);
    }

}
