/**
 * Leetcode - path_with_minimum_effort
 */
package com.leetcode.path_with_minimum_effort;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        queue.add(new int[]{0, 0, 0, 0, 0});
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            int height = val[0];
            int x1 = val[1], y1 = val[2];
            int x2 = val[3], y2 = val[4];
            if(seen[x2][y2]) {
                continue;
            }
            dist[x2][y2] = Math.max(dist[x2][y2], height);
            dist[x2][y2] = Math.max(dist[x2][y2], dist[x1][y1]);
            seen[x2][y2] = true;
            if (x2 == m - 1 && y2 == n - 1) {
                return dist[x2][y2];
            }

            if (x2 < m - 1) {
                queue.add(new int[]{Math.abs(heights[x2 + 1][y2] - heights[x2][y2]), x2, y2, x2 + 1, y2});
            }
            if(y2 < n - 1) {
                queue.add(new int[]{Math.abs(heights[x2][y2 + 1] - heights[x2][y2]), x2, y2, x2, y2 + 1});
            }
            if(x2 > 0) {
                queue.add(new int[]{Math.abs(heights[x2 - 1][y2] - heights[x2][y2]), x2, y2, x2 - 1, y2});
            }
            if(y2 > 0) {
                queue.add(new int[]{Math.abs(heights[x2][y2 - 1] - heights[x2][y2]), x2, y2, x2, y2 - 1});
            }
        }

        return 0;
    }

}
