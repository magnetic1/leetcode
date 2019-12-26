/**
 * Leetcode - next_permutation
 */
package com.leetcode.next_permutation;
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

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int len = nums.length;

        for (int i = len - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                // i+1到结束都是降序
                for (int j = len - 1; j > i; j--) {
                    if (nums[i] < nums[j]) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        reverseArray(nums, i + 1, len - 1);
                        return;
                    }
                }
            }
        }

        reverseArray(nums, 0, len - 1);

    }

    private void reverseArray(int[] nums, int begin, int end){
        for (int i = begin, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {1,3,2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
