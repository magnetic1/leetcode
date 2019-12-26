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
class Solution2 implements Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reachable = 0;

        int i = 0;

        while (i <= reachable && i < n) {

            reachable = Math.max(reachable, i + nums[i]);

            i++;
        }

        return i == n;
    }

}
