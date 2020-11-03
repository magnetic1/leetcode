/**
 * Leetcode - intersection_of_two_arrays
 */
package com.leetcode.intersection_of_two_arrays;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        int[] res = Arrays.stream(nums2)
                .filter(set::contains)
                .distinct().parallel()
                .toArray();

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        solution.intersection(new int[]{1,2}, new int[]{2, 1, 2});
    }
}
