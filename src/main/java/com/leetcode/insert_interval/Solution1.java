/**
 * Leetcode - insert_interval
 */
package com.leetcode.insert_interval;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();

        int i = 0;
        // 确定插入newInterval的第一个值
        while (i < intervals.length) {
            int[] interval = intervals[i];

            if (interval[1] < newInterval[0]) {
                ret.add(interval);
            } else if (interval[0] <= newInterval[0]) {
                // like [0,2]; [1,2]
                newInterval[0] = interval[0];
                break;
            } else if (interval[0] <= newInterval[1]) {
                // like [2,3]; [1,2]
                break;
            } else {
                break;
            }
            i++;
        }


        // 确定插入newInterval的第二个值
        while (i < intervals.length) {
            int[] interval = intervals[i];

            if (interval[0] > newInterval[1]) {
                // like [2,3]; [0,1]
                ret.add(newInterval);
                ret.add(interval);
                break;
            } else if (interval[1] > newInterval[1]) {
                newInterval[1] = interval[1];
                ret.add(newInterval);
                break;
            }

            i++;
        }

        if (ret.size() == 0 || ret.get(ret.size() - 1)[1] < newInterval[1]) {
            ret.add(newInterval);
        }

        i++;
        while (i < intervals.length) {
            ret.add(intervals[i]);
            i++;
        }


        return ret.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        Solution1 solution = new Solution1();

        System.out.println(
                Arrays.asList(solution.insert(intervals, newInterval))
                        .stream()
                        .map(interval -> Arrays.asList(interval[0], interval[1]))
                        .collect(Collectors.toList())
        );

    }

}
