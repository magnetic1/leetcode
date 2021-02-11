/**
 * Leetcode - kth_largest_element_in_a_stream
 */
package com.leetcode.kth_largest_element_in_a_stream;
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
class Solution1 implements Solution { }

class KthLargest {
    int k;
    int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new int[k];
        Arrays.fill(this.nums, Integer.MIN_VALUE);
        for(int num : nums) {
            insert(num);
        }
    }

    void insert(int val) {
        int i = k - 1;
        while(i >= 0 && nums[i] < val) {
            i--;
        }

        if(i < k - 1) {
            System.arraycopy(nums, i + 1, nums, i + 2, k - i - 2);
            nums[i + 1] = val;
        }
    }

    public int add(int val) {
        insert(val);
        return nums[k - 1];
    }
}