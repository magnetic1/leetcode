/**
 * Leetcode - valid_mountain_array
 */
package com.leetcode.valid_mountain_array;
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

    public boolean validMountainArray(int[] A) {
        if(A.length < 3) {
            return false;
        }

        int Start = 0, Up = 1, Down = 2;
        int state = Start;
        for(int i = 1; i < A.length; i++) {
            if(state == Down) {
                if(A[i] < A[i - 1]) {
                    continue;
                } else {
                    return false;
                }
            } else if (state == Up) {
                if(A[i] < A[i - 1]) {
                    state = Down;
                    continue;
                } else if(A[i] > A[i - 1]) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if(A[i] > A[i - 1]) {
                    state = Up;
                } else {
                    return false;
                }
            }
        }

        return state == Down;
    }

}
