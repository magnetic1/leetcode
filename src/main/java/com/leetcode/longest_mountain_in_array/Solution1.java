/**
 * Leetcode - longest_mountain_in_array
 */
package com.leetcode.longest_mountain_in_array;
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

    public int longestMountain(int[] A) {
        if(A.length == 0) {
            return 0;
        }

        int UP = 0, DOWN = 1, PLAIN = 2;
        int state = PLAIN, ret = 0;

        int num = A[0], len = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > num) {
                if(state == UP) {
                    len++;
                } else if(state == DOWN) {
                    ret = Math.max(ret, len);
                    len = 2;
                    state = UP;
                } else {
                    len = 2;
                    state = UP;
                }
            } else if(A[i] < num) {
                if(state == DOWN) {
                    len++;
                } else if(state == UP) {
                    len++;
                    state = DOWN;
                }
            } else {
                if(state == DOWN) {
                    ret = Math.max(ret, len);
                    len = 1;
                    state = PLAIN;
                } else if(state == UP) {
                    len = 1;
                    state = PLAIN;
                }
            }

            num = A[i];
        }

        if(state == DOWN) {
            ret = Math.max(ret, len);
        }
        return ret;
    }

}
