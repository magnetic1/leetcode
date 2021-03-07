/**
 * Leetcode - palindrome_partitioning
 */
package com.leetcode.palindrome_partitioning;
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
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int N;

    public List<List<String>> partition(String s) {
        N = s.length();
        boolean[][] f = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            f[i][i] = true;
        }
        for(int i = N - 2; i >= 0; i--) {
            f[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            for(int j = i + 2; j < N; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        dfs(s, f, 0);

        return ans;
    }

    void dfs(String s, boolean[][] f, int index) {
        if(index == N) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < N; i++) {
            if(f[index][i]) {
                list.add(s.substring(index, i + 1));
                dfs(s, f, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
}
