/**
 * Leetcode - grumpy_bookstore_owner
 */
package com.leetcode.grumpy_bookstore_owner;
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

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                ans += customers[i];
            }
        }

        int newCustoms = 0;
        for(int i = 0; i < X; i++) {
            if(grumpy[i] == 1) {
                newCustoms += customers[i];
            }
        }
        int max = newCustoms;
        for(int i = X; i < n; i++) {
            if(grumpy[i - X] == 1) {
                newCustoms -= customers[i - X];
            }
            if(grumpy[i] == 1) {
                newCustoms += customers[i];
            }
            max = Math.max(max, newCustoms);
        }

        return ans + max;
    }

}
