/**
 * Leetcode - longest_turbulent_subarray
 */
package com.leetcode.longest_turbulent_subarray;
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

    public int maxTurbulenceSize(int[] arr) {
        int ans = 1, n = arr.length, len = 1;

        int i = 1;
        while(i < n) {
            boolean isLower = false;
            while(i < n) {
                if(arr[i] == arr[i - 1]) {
                    i++;
                } else {
                    isLower = arr[i] < arr[i - 1];
                    len = 2;
                    i++;
                    break;
                }
            }
            ans = Math.max(ans, len);

            for(; i < n; i++) {
                if(((arr[i] < arr[i - 1]) && !isLower) || ((arr[i] > arr[i - 1]) && isLower)) {
                    len++;
                    isLower = !isLower;
                    ans = Math.max(ans, len);
                } else {
                    len = 2;
                    break;
                }
            }
        }

        return ans;
    }

}
