/**
 * Leetcode - redundant_connection
 */
package com.leetcode.redundant_connection;

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
class Solution1 implements Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for(int[] edge : edges) {
            n = edge[0] > edge[1] ? (Math.max(edge[0], n)) : (Math.max(edge[1], n));
        }
        int[] p = new int[n + 1];
        for(int i = 0; i < n; i++) {
            p[i + 1] = i + 1;
        }

        for(int[] edge : edges) {
            int a = find(p, edge[0]);
            int b = find(p, edge[1]);
            if(a != b) {
                p[b] = a;
            } else {
                return edge;
            }
        }

        return new int[] {0, 0};
    }

    int find(int[] p, int i) {
        if(p[i] != i) {
            p[i] = find(p, p[i]);
        }
        return p[i];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.findRedundantConnection(new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 3}
        });
    }

}
