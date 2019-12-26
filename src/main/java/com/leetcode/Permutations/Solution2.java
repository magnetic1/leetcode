/**
 * Leetcode - Permutations
 */
package com.leetcode.Permutations;
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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, int idx) {
        if(idx == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            res.add(tmp);
        }

        for(int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            helper(nums, res, idx + 1);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i ,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

}
