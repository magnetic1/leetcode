/**
 * Leetcode - max_consecutive_ones_iii
 */
package com.leetcode.max_consecutive_ones_iii;
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

    public int longestOnes(int[] A, int K) {
        int zeros = 0;
        int n = A.length, right = 0, left = 0;

        while(right < n) {
            zeros += 1 - A[right];
            if(zeros > K) {
                zeros -= 1 - A[left];
                left++;
            }
            right++;
        }

        return right - left;
    }

}
