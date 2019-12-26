/**
 * Leetcode - combination_sum
 */
package com.leetcode.combination_sum;

import java.io.*;
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
class Solution1 implements Solution {

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        int index = candidates.length - 1;

        combinationSum(candidates, target, 0, index, new ArrayList<>(), result);

        return result;
    }

    private void combinationSum(int[] candidates, int target, int sum, int index,
                                List<Integer> list, List<List<Integer>> result) {
        int candidate = candidates[index];
        if (index == 0) {
            if (target - sum > candidate) {
                list.add(candidate);
                combinationSum(candidates, target, sum + candidate, index, list, result);
                list.remove(list.size() - 1);
            } else if (target - sum == candidate) {
                list.add(candidate);
                result.add(copy(list));
                list.remove(list.size() - 1);
            } else {
                return;
            }

        } else {
            if (target - sum > candidate) {

                for (int i = index; i >= 0; i--) {
                    list.add(candidates[i]);
                    combinationSum(candidates, target, sum + candidates[i], i, list, result);
                    list.remove(list.size() - 1);
                }

            } else if (target - sum == candidate) {
                list.add(candidate);
                result.add(copy(list));
                list.remove(list.size() - 1);
                combinationSum(candidates, target, sum, index - 1, list, result);
            } else {
                combinationSum(candidates, target, sum, index - 1, list, result);
            }
        }


    }

    public static List<Integer> copy(List<Integer> src) {
        return new ArrayList<>(src);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
