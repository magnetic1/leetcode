/**
 * Leetcode - subsets_ii
 */
package com.leetcode.subsets_ii;
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

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int step) {
        res.add(new ArrayList<>(tempList));

        for (int i = step; i < nums.length; i++) {
            if (i > step && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            dfs(nums, i + 1);
            tempList.remove(tempList.size() - 1);

        }
    }

}
