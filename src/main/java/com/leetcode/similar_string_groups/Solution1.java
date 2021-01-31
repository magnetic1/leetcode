/**
 * Leetcode - similar_string_groups
 */
package com.leetcode.similar_string_groups;
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

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                String str1 = strs[i];
                String str2 = strs[j];
                if(isSimilar(str1, str2)) {
                    uf.unite(i, j);
                }
            }
        }

        return uf.setCount;
    }

    boolean isSimilar(String str1, String str2) {
        int n = str1.length(), count = 0;
        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if(count > 2) {
                return false;
            }
        }
        return true;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int setCount;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        setCount = n;
        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean unite(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return false;
        }
        if(size[x] < size[y]) {
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
