/**
 * Leetcode - parallel_courses_ii
 */
package com.leetcode.parallel_courses_ii;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

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
    @SuppressWarnings({"unchecked"})
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        List<Integer>[] dependenciesLists = (List<Integer>[]) new ArrayList[n];
        boolean[] masks = new boolean[n];


        for (int i = 0; i < dependenciesLists.length; i++) {
            dependenciesLists[i] = new ArrayList<>();
        }

        for (int[] de : dependencies) {
            dependenciesLists[de[1] - 1].add(de[0] - 1);
        }


        int ans = 0;
        List<Integer> to_study = new ArrayList<>(k);
        Arrays.fill(masks, false);

        while (!isFinished(masks)) {
//            System.out.println("====loop====");
            int num = 0;
            for (int i = 0; i < n; i++) {
                if (num == k) {
                    break;
                }
                num = study(i, dependenciesLists, to_study, masks, num, k);
            }

            for (int i : to_study) {
                masks[i] = true;
            }
            to_study = new ArrayList<>(k);
            ans++;
        }

        return ans;
    }

    int study(int course_num, List<Integer>[] dependenciesLists, List<Integer> to_study, boolean[] masks, int num, int k) {
        if (masks[course_num] || to_study.contains(course_num)) {
            return num;
        }
        List<Integer> dependenciesList = dependenciesLists[course_num];

        if (dependenciesList.size() == 0 && num < k) {
//            System.out.println("1 study " + course_num);
            to_study.add(course_num);
            return num + 1;
        }

        if (num < k && isChildrenFinished(masks, dependenciesList)) {
//            System.out.println("3 study" + course_num);
            to_study.add(course_num);
            num++;
        }

//        int new_num = num;
        for (int i : dependenciesList) {
            // 学满
            if (num == k) {
                return num;
            } else if (masks[i] || to_study.contains(i)) {
//                正在学或已学
                continue;
            }

            int temp_num = study(i, dependenciesLists, to_study, masks, num, k);
            if (num == temp_num && isChildrenFinished(masks, dependenciesList)) {
//                System.out.println("2 study " + i);
                to_study.add(i);
                num++;
            } else {
                num = temp_num;
            }
        }
        return num;
    }

    boolean isChildrenFinished(boolean[] masks, List<Integer> dependenciesList) {
        if (dependenciesList.size() == 0) {
            return true;
        }

        for (int index : dependenciesList) {
            boolean mask = masks[index];
            if (!mask) {
                return false;
            }
        }
        return true;
    }

    boolean isFinished(boolean[] masks) {
        for (boolean mask : masks) {
            if (!mask) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int n = 12;
        int[][] dependencies = {
//                {2, 1}, {3, 1}, {4, 1}, {1, 5},
                {1, 2}, {1, 3}, {7, 5}, {7, 6}, {4, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}
        };

        int k = 2;
        int res = solution.minNumberOfSemesters(n, dependencies, k);
        System.out.println(res);

//        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        System.out.println(list.contains(2));

    }
}
