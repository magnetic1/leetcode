/**
 * Leetcode - min_cost_to_connect_all_points
 */
package com.leetcode.min_cost_to_connect_all_points;

import java.util.*;
import java.util.function.IntBinaryOperator;

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
class Solution1 implements Solution {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] lowCost = new int[n];

        lowCost[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            lowCost[i] = distance(points, 0, i);
        }

        int num = 1, ans = 0;
        while (num < n) {
            int min = lowCost[0];
            int min_index = 0;
            for (int i = 1; i < n; i++) {
                if (lowCost[i] < min) {
                    min = lowCost[i];
                    min_index = i;
                }
            }
            lowCost[min_index] = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (lowCost[i] != Integer.MAX_VALUE) {
                    lowCost[i] = Math.min(lowCost[i], distance(points, i, min_index));
                }
            }
            num++;
            ans += min;
        }
        return ans;
    }

    int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
