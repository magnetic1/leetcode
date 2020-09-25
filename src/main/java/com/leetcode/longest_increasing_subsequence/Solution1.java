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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] lens = new int[n];

        lens[0] = 1;

        for(int i = 1; i< n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    lens[i] = Math.max(lens[j] + 1, lens[i]);
                }
            }
            if(lens[i] == 0)
                lens[i] = 1;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(lens[i] > max) {
                max = lens[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
