/**
 * Leetcode - maximum_gap
 */
package com.leetcode.maximum_gap;
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
class Solution2 implements Solution {

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return 0;
        }

        int[] buf = new int[n];
        long exp = 1;
        int maxV = Arrays.stream(nums).max().getAsInt();

        while (maxV >= exp) {
            int[] cur = new int[10];
            for (int v : nums) {
                int digit = (v / (int) exp) % 10;
                cur[digit]++;
            }

            for(int i = 1; i < 10; i++) {
                cur[i] += cur[i - 1];
            }

            for(int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cur[digit] - 1] = nums[i];
                cur[digit]--;
            }
            exp *= 10;

            System.arraycopy(buf, 0, nums, 0, n);
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }

        return res;
    }

}
