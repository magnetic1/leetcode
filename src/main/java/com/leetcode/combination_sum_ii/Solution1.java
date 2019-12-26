/**
 * Leetcode - combination_sum_ii
 */
package com.leetcode.combination_sum_ii;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        int index = candidates.length - 1;
        combinationSum(candidates, target, 0, index, new ArrayList<>(), result);


        return new ArrayList<>(new HashSet<>(result));
    }


    private void combinationSum(int[] candidates, int target, int sum, int index,
                                List<Integer> list, List<List<Integer>> result) {
        int candidate = candidates[index];

//        System.out.println(index + ": " + list.toString());
//        System.out.println( "sum: " + sum);

        if (index == 0) {
            if (candidate + sum < target) {
                return;
            } else if (target - sum == candidate) {
                list.add(candidate);
                result.add(copy(list));
                list.remove(list.size() - 1);
            } else {
                return;
            }

        } else {
            if (candidate + sum < target) {
                for (int i = index; i > 0; i--) {
                    list.add(candidates[i]);
                    combinationSum(candidates, target, sum + candidates[i], i - 1, list, result);
                    list.remove(list.size() - 1);
                }

            } else if (candidate + sum == target) {
                list.add(candidate);
                result.add(copy(list));
                list.remove(list.size() - 1);
                do {
                    index--;
                } while (index > 0 && candidates[index] == candidates[index + 1]) ;
                combinationSum(candidates, target, sum, index, list, result);

            } else {
                do {
                    index--;
                } while (index > 0 && candidates[index] == candidates[index + 1]) ;
                combinationSum(candidates, target, sum, index, list, result);
            }
        }


    }

    public static List<Integer> copy(List<Integer> src) {
        return new ArrayList<>(src);
    }


    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        System.out.println(solution.combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8));

    }
}
