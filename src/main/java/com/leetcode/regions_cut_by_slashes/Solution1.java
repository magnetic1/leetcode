/**
 * Leetcode - regions_cut_by_slashes
 */
package com.leetcode.regions_cut_by_slashes;
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

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n);


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if(c == '\\') {
                    uf.unite(i * (n + 1) + j, (i + 1) * (n + 1) + (j + 1));
                } else if(c == '/') {
                    uf.unite(i * (n + 1) + (j + 1), (i + 1) * (n + 1) + j);
                }
            }
        }

        return uf.areas;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int areas;

    public UnionFind(int n) {
        int len = (n + 1) * (n + 1);
        parent = new int[len];
        size = new int[len];
        Arrays.fill(size, 1);
        for(int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            this.unite(i, i + 1);
            this.unite((n + 1) * n + i, (n + 1) * n + (i + 1));
            this.unite((n + 1) * i + n, (n + 1) * (i + 1) + n);
            this.unite((n + 1) * i, (n + 1) * (i + 1));
        }
        areas = 1;
    }

    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean unite(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            areas++;
            return false;
        }
        if(size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parent[y] = x;
        size[x] += y;

        return true;
    }
}
