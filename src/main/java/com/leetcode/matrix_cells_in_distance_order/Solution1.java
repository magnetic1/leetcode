/**
 * Leetcode - matrix_cells_in_distance_order
 */
package com.leetcode.matrix_cells_in_distance_order;
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

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]>[] p = new ArrayList[R + C];

        for(int i = 0; i < R + C; i++) {
            p[i] = new ArrayList<>();
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dis = Math.abs(r - r0) + Math.abs(c - c0);
                p[dis].add(new int[] {r, c});
            }
        }

        int[][] res = new int[R * C][2];
        int i = 0;
        for(List<int[]> list : p) {
            for (int[] pair : list) {
                res[i] = pair;
                i++;
            }
        }

        return res;
    }

}
