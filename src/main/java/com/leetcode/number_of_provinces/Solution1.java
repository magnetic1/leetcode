/**
 * Leetcode - number_of_provinces
 */
package com.leetcode.number_of_provinces;
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

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parents = new int[n];
        int ans = n;
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    int a = find(i, parents);
                    int b = find(j, parents);
                    if(a != b) {
                        parents[a] = b;
                        ans--;
                    }
                }
            }
        }

        return ans;
    }

    int find(int i, int[] parents) {
        if(parents[i] != i) {
            parents[i] = find(parents[i], parents);
        }
        return parents[i];
    }

}
