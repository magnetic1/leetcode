/**
 * Leetcode - brick_wall
 */
package com.leetcode.brick_wall;
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

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> bricks : wall) {
            int len = 0;
            for (int i = 0; i < bricks.size() - 1; i++) {
                len += bricks.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
            }
        }

        int max = 0;
        for (int value : map.values()) {
            max = Math.max(value, max);
        }

        return wall.size() - max;
    }

}
