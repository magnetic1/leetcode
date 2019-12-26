/**
 * Leetcode - permutations_ii
 */
package com.leetcode.permutations_ii;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        helper(nums, marked, res, 0);
        return res;
    }

    private void helper(int[] nums, boolean[] marked, List<List<Integer>> res, int idx) {
        if(idx == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            res.add(tmp);
        }

        for(int i = idx; i < nums.length; i++) {
            if (!marked[i] && nums[i] == nums[idx]) {
                continue;
            }
            swap(nums, i, idx);
            marked[i] = true;
            helper(nums, marked, res, idx + 1);
            swap(nums, i, idx);
            marked[i] = false;

        }
    }

    private void swap(int[] nums, int i ,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.permuteUnique(new int[]{2, 2, 1, 1}));
    }

}
