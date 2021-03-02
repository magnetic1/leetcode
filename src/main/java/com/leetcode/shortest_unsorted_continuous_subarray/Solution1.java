/**
 * Leetcode - shortest_unsorted_continuous_subarray
 */
package com.leetcode.shortest_unsorted_continuous_subarray;
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

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        System.arraycopy(nums, 0, a, 0, n);
        Arrays.sort(a);

        int i = 0;
        while(i < n && a[i] == nums[i]) {
            i++;
        }

        int j = n - 1;
        while(j >= 0 && a[j] == nums[j]) {
            j--;
        }

        return j >= i ? j - i + 1 : 0;
    }

}
