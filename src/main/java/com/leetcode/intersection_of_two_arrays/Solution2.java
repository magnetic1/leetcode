/**
 * Leetcode - intersection_of_two_arrays
 */
package com.leetcode.intersection_of_two_arrays;
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

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int num : nums1) {
            set.add(num);
        }

        for(int num : nums2) {
            if(set.contains(num)) {
                set.remove(num);
                list.add(num);
            }
        }


        return list.stream().mapToInt(value -> value).toArray();
    }

}
