/**
 * Leetcode - swim_in_rising_water
 */
package com.leetcode.swim_in_rising_water;
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

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int M = N * N - 1;

        int low = grid[0][0], high = M;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(possible(mid, grid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean possible(int T, int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        seen.add(0);
        stack.push(0);
        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, -1, 1};

        while(!stack.isEmpty()) {
            int k = stack.pop();
            int r = k / N, c = k % N;
            if(r == N-1 && c == N-1) {
                return true;
            }

            for(int i = 0; i < 4; i++) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;

                if(cr >= 0 && cr < N && cc >= 0 && cc < N && grid[cr][cc] <= T && !seen.contains(ck)) {
                    stack.push(ck);
                    seen.add(ck);
                }
            }
        }

        return false;
    }

}
