/**
 * Leetcode - find_all_numbers_disappeared_in_an_array
 */
package com.leetcode.find_all_numbers_disappeared_in_an_array;
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

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n) {
            if(nums[i] == i + 1 || nums[i] == 0) {
                i++;
                continue;
            }

            int v = nums[i];
            if(nums[v - 1] != v) {
                nums[i] = nums[v - 1];
                nums[v - 1] = v;
            } else {
                nums[i] = 0;
                i++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }

}
