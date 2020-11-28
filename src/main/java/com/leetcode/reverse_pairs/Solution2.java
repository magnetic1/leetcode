/**
 * Leetcode - reverse_pairs
 */
package com.leetcode.reverse_pairs;
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

    public int reversePairs(int[] nums) {
        int[] buf = new int[nums.length];
        return reversePairs(nums, buf,  0, nums.length - 1);
    }

    int reversePairs(int[] nums, int[] buf, int l, int r) {
        if(l >= r) {
            return 0;
        }

        int mid = (l + r) / 2;
        int pl = reversePairs(nums, buf, l, mid);
        int pr = reversePairs(nums, buf, mid + 1, r);

        int p = 0;
        int l_ptr = l, r_ptr = mid + 1;
        while(l_ptr <= mid && r_ptr <= r) {
            if(nums[l_ptr] > 2 * (long) nums[r_ptr]) {
                p += mid - l_ptr + 1;
                r_ptr++;
            } else {
                l_ptr++;
            }
        }

        int ptr = l;
        l_ptr = l;
        r_ptr = mid + 1;
        while(l_ptr <= mid && r_ptr <= r) {
            if(nums[l_ptr] < nums[r_ptr]) {
                buf[ptr++] = nums[l_ptr++];
            } else {
                buf[ptr++] = nums[r_ptr++];
            }
        }

        if(l_ptr > mid) {
            System.arraycopy(nums, r_ptr, buf, ptr, r - r_ptr + 1);
        } else {
            System.arraycopy(nums, l_ptr, buf, ptr, mid - l_ptr + 1);
        }
        System.arraycopy(buf, l, nums, l, r - l + 1);

        return pl + pr + p;
    }

}
