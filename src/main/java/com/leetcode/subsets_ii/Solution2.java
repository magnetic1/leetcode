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
class Solution2 implements Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList<>());

        for(int i = 1; i <= nums.length; i++) {
            search(nums, 0, i, new ArrayList<>());
        }

        return ans;
    }

    void search(int[] nums, int i, int len, List<Integer> list) {
        int n = nums.length;

        if(n < i + len) {
            return;
        }

        if(len == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        int value = nums[i] - 1;
        for(; i < n; i++) {
            if(nums[i] != value) {
                list.add(nums[i]);
                search(nums, i + 1, len - 1, list);
                list.remove(list.size() - 1);
                value = nums[i];
            }
        }

    }

}
