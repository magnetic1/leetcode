/**
 * Leetcode - jump_game
 */
package com.leetcode.jump_game;
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

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] jumps = new int[n];

        jumps[0] = 1;
        int reachable = 0, nextReachable;

        for (int k = 0; k <= reachable && k < n; k++) {
            nextReachable = k + nums[k];

            for (int i = reachable + 1; i <= nextReachable && i < n; i++) {
                jumps[i] = jumps[k] + 1;
            }

            reachable = Math.max(reachable, nextReachable);
        }

        return jumps[n - 1] > 0;
    }

}
