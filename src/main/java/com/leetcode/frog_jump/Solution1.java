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
class Solution1 implements Solution {

    public boolean canCross(int[] stones) {
        if (stones.length <= 0) {
            return false;
        }
        if (stones.length == 1) {
            return true;
        }
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        Set<Integer>[] jumps = new HashSet[stones.length];
        jumps[0] = new HashSet<>();
        jumps[0].add(1);

        for (int i = 1; i < stones.length; i++) {
            jumps[i] = new HashSet<>();
            for (int j = 0; j < i; j++) {
                for (int jump : jumps[i]) {
                    if (jump + stones[j] == stones[i]) {
                        jumps[i].add(jump);
                    } else if (jump + stones[j] + 1 == stones[i]) {
                        jumps[i].add(jump + 1);
                    } else if (jump + stones[j] - 1 == stones[i]) {
                        jumps[i].add(jump - 1);
                    }
                }
            }
        }
        return !jumps[stones.length - 1].isEmpty();
    }

    public static void main(String[] args) {

    }

}
