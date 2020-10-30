/**
 * Leetcode - island_perimeter
 */
package com.leetcode.island_perimeter;
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

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int sum = 0, d = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    sum++;
                    if(i < m - 1 && grid[i + 1][j] == 1) {
                        d++;
                    }
                    if(j < n - 1 && grid[i][j + 1] == 1) {
                        d++;
                    }
                }
            }
        }

        return 4 * sum - 2 * d;
    }

}
