/**
 * Leetcode - Permutations
 */
package com.leetcode.Permutations;

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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer, Integer> numMap = new HashMap<>();
        Arrays.stream(nums).forEach(num ->
                numMap.put(num, num)
        );

        return add(numMap, nums.length);


    }

    private List<List<Integer>> add(HashMap<Integer, Integer> numMap, int num) {
        if (num == 0) {
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(new ArrayList<>());
            return lists;
        }

        return numMap.values().stream().flatMap(integer -> {
            HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) numMap.clone();
            map.remove(integer, integer);
            List<List<Integer>> lastList = add(map, num - 1);

            return lastList
                    .stream()
                    .peek(list -> list.add(integer));
        }).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

}
