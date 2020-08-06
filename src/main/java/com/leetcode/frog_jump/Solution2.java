/**
 * Leetcode - frog_jump
 */
package com.leetcode.frog_jump;
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

    public boolean canCross(int[] stones) {
        for (int i = 1; i < stones.length; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        return dfs(stones, 0, 1);
    }

    private boolean dfs(int[] stones, int index, int jump) {
        if (index == stones.length - 1) {
            return true;
        }
        if (index < 0 || jump < 1) {
            return false;
        }

        for (int i = jump - 1; i <= jump + 1; i++) {
            int next = Arrays.binarySearch(stones, stones[index] + i);
            if (dfs(stones, next, i)) {
                return true;
            }
        }
        return false;
    }

}
