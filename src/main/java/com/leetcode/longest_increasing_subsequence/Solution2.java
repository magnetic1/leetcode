/**
 * Leetcode - longest_increasing_subsequence
 */
package com.leetcode.longest_increasing_subsequence;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {
    // 方法二：贪心 + 二分查找
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length, len = 1;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            int l = 1, r = len, pos = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (d[mid] > nums[i]) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            d[pos + 1] = nums[i];
            len = Math.max(len, pos + 1);
        }

        return len;
    }

}
