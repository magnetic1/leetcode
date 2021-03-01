/**
 * Leetcode - monotonic_array
 */
package com.leetcode.monotonic_array;
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

    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if(n == 0 || n == 1) {
            return true;
        }

        int status = 0;
        for(int i = 1; i < n; i++) {
            if(status == 1) {
                if(A[i] > A[i - 1]) {
                    return false;
                }
            } else if(status == 2) {
                if(A[i] < A[i - 1]) {
                    return false;
                }
            } else {
                if(A[i] < A[i - 1]) {
                    status = 1;
                } else if(A[i] > A[i - 1]) {
                    status = 2;
                }
            }
        }

        return true;
    }

}
