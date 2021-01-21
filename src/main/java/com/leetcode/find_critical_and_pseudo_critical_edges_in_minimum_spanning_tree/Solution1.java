/**
 * Leetcode - find_critical_and_pseudo_critical_edges_in_minimum_spanning_tree
 */
package com.leetcode.find_critical_and_pseudo_critical_edges_in_minimum_spanning_tree;
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

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for(int i = 0; i < m; i++) {
            System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, (u, v) -> u[2] - v[2]);

        int value = 0;
        UnionFind uf = new UnionFind(n);
        int index = 0;
        while(uf.setCount > 1 && index < m) {
            int[] newEdge = newEdges[index];
            if(uf.unite(newEdge[0], newEdge[1])) {
                value += newEdge[2];
            }
            index++;
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int min = value;
        for(int i = 0; i < m; i++) {
            uf = new UnionFind(n);
            index = 0;
            value = 0;
            while(uf.setCount > 1 && index < m) {
                int[] newEdge = newEdges[index];
                if(index != i && uf.unite(newEdge[0], newEdge[1])) {
                    value += newEdge[2];
                }
                index++;
            }
            if(uf.setCount > 1 || value > min) {
                ans.get(0).add(newEdges[i][3]);
                continue;
            }

            uf = new UnionFind(n);
            index = 0;
            value = 0;
            uf.unite(newEdges[i][0], newEdges[i][1]);
            value += newEdges[i][2];
            while(uf.setCount > 1 && index < m) {
                int[] newEdge = newEdges[index];
                if(index != i && uf.unite(newEdge[0], newEdge[1])) {
                    value += newEdge[2];
                }
                index++;
            }

            if(uf.setCount == 1 && value == min) {
                ans.get(1).add(newEdges[i][3]);
            }
        }

        return ans;
    }
}

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
