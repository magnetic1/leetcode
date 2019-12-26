/**
 * Leetcode - permutations_ii
 */
package com.leetcode.permutations_ii;

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

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(res, nums, visited, new ArrayList<Integer>());
        return res;
    }

    // Visited arrays are used to mark whether elements have been visited
    private void backtrack(List<List<Integer>> res, int[] nums, int[] visited, ArrayList<Integer> temp_list) {
        if (temp_list.size() == nums.length) {
            res.add(new ArrayList<>(temp_list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1])) continue;
            visited[i] = 1;
            temp_list.add(nums[i]);
            // System.out.println("temp_list:"+temp_list);
            backtrack(res, nums, visited, temp_list);
            visited[i] = 0;
            temp_list.remove(temp_list.size() - 1);
            // System.out.println("removed temp_list:"+temp_list);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.permuteUnique(new int[]{2, 2, 1, 1}));
    }

}
