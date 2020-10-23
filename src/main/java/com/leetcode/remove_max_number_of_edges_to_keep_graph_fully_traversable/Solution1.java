/**
 * Leetcode - remove_max_number_of_edges_to_keep_graph_fully_traversable
 */
package com.leetcode.remove_max_number_of_edges_to_keep_graph_fully_traversable;
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

    int find(int[] f, int i) {
        if(f[i] == i) {
            return i;
        } else {
            f[i] = find(f, f[i]);
            return f[i];
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] f0 = new int[n + 1], f1 = new int[n + 1], f2 = new int[n + 1];
        int m = edges.length;
        int s = 0, s1 = 0, s2 = 0;
        for(int i = 1; i <= n; i++) {
            f0[i] = i;
            f1[i] = i;
            f2[i] = i;
        }
        for(int i = 0; i < m; i++) {
            int c = edges[i][0], a = edges[i][1], b = edges[i][2];
            if(c == 3) {
                int aa = find(f0, a), bb = find(f0, b);
                if(aa != bb) {
                    f0[aa] = bb;
                    s++;
                    aa = find(f1, a);
                    bb = find(f1, b);
                    f1[aa] = bb;
                    s1++;
                    aa = find(f2, a);
                    bb = find(f2, b);
                    f2[aa] = bb;
                    s2++;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            int c = edges[i][0], a = edges[i][1], b = edges[i][2];
            if(c == 1) {
                int aa = find(f1, a), bb = find(f1, b);
                if(aa != bb) {
                    f1[aa] = bb;
                    s++;
                    s1++;
                }
            } else if(c == 2) {
                int aa = find(f2, a), bb = find(f2, b);
                if(aa != bb) {
                    f2[aa] = bb;
                    s++;
                    s2++;
                }
            }
        }
        if(s1 != n - 1 || s2 != n - 1) {
            return -1;
        }
        return m - s;
    }

}
