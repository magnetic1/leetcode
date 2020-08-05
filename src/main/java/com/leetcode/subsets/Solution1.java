/**
 * Leetcode - subsets
 */
package com.leetcode.subsets;
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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>(tempList));
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int n) {
        if (n == nums.length) {
            return;
        }
        for (int i = n; i < nums.length; i++) {
            tempList.add(nums[i]);
            res.add(new ArrayList<>(tempList));
            dfs(nums, i + 1);
            tempList.remove((Integer) nums[i]);
        }
    }

    public static void main(String[] args) {

    }

}
