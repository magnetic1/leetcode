/**
 * Leetcode - check_if_it_is_a_straight_line
 */
package com.leetcode.check_if_it_is_a_straight_line;
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

    public boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];
        for(int i = 2; i < coordinates.length; i++) {
            int x1 = point2[0] - point1[0], y1 = point2[1] - point1[1];
            int x2 = coordinates[i][0] - point1[0], y2 = coordinates[i][1] - point1[1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }

        return true;
    }

}
