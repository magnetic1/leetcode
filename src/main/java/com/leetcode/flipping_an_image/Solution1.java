/**
 * Leetcode - flipping_an_image
 */
package com.leetcode.flipping_an_image;
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

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < (n + 1) / 2; j++) {
                int t = A[i][j] ^ 1;
                A[i][j] = A[i][n - 1 - j] ^ 1;
                A[i][n - 1 -j] = t;
            }
        }

        return A;
    }

}
