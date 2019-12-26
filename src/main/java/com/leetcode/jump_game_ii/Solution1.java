/**
 * Leetcode - jump_game_ii
 */
package com.leetcode.jump_game_ii;
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

    public int jump(int[] nums) {
        int n = nums.length;
        int[] jumps = new int[n];

        int reachable = 0;

        for (int k = 0; reachable < n - 1; k++) {
            int nextReachable = k + nums[k];
            for (int i = reachable + 1; i <= nextReachable && i < n; i++) {
                jumps[i] = jumps[k] + 1;
            }
            reachable = Math.max(reachable, nextReachable);
        }

        return jumps[n - 1];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.jump(new int[]{2,1,1,1,4}));
    }
}
