/**
 * Leetcode - three_sum
 */
package com.leetcode.three_sum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Set<Integer>> sumSet = new HashSet<>();

//        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        sumSet.add(new HashSet<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }

        return sumSet.stream()
                .map(set -> {
                    List<Integer> list = new ArrayList<>(set);
                    while (list.size() < 3) {
                        Integer min = Integer.MAX_VALUE;
                        for (Integer i : list) {
                            if (Math.abs(i) < Math.abs(min)) {
                                min = i;
                            }
                        }
                        list.add(min);
                    }
                    return list;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4,0,0}));

        Set<Integer> set1 = Arrays.stream(new int[]{-1, 0, 1}).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(new int[]{0, 1, -1}).boxed().collect(Collectors.toSet());

        System.out.println(set1.equals(set2));

    }

}
