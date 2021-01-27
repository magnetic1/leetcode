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
class Solution2 implements Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        UnionFind uf1 = new UnionFind(n);
        UnionFind uf2 = new UnionFind(n);
        for(int[] edge : edges) {
            int type = edge[0], node1 = edge[1] -1, node2 = edge[2] - 1;
            if(type == 3) {
                if(!uf1.unite(node1, node2)) {
                    ans++;
                } else {
                    uf2.unite(node1, node2);
                }
            }
        }

        for(int[] edge : edges) {
            int type = edge[0], node1 = edge[1] -1, node2 = edge[2] - 1;
            if(type == 1) {
                if(!uf1.unite(node1, node2)) {
                    ans++;
                }
            } else if(type == 2) {
                if(!uf2.unite(node1, node2)) {
                    ans++;
                }
            }
        }
        if(uf1.setCount == 1 && uf2.setCount == 1) {
            return ans++;
        } else {
            return -1;
        }
    }
}

// 并查集模板
class UnionFind {
    int[] parent;
    int[] size;
    int n;
    // 当前连通分量数目
    int setCount;

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = findset(x);
        y = findset(y);
        return x == y;
    }
}
