/**
 * Leetcode - number_of_operations_to_make_network_connected
 */
package com.leetcode.number_of_operations_to_make_network_connected;

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

    public int makeConnected(int n, int[][] connections) {
        int num = connections.length;
        if (num < n - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            uf.unite(connection[0], connection[1]);
        }

        return uf.setCount - 1;

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
        size = new int[n];
        parent = new int[n];
        setCount = n;
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public boolean unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parent[y] = x;
        size[x] += size[y];
        setCount--;
        return true;
    }

}