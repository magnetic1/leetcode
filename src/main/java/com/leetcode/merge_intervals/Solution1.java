/**
 * Leetcode - merge_intervals
 */
package com.leetcode.merge_intervals;
import java.util.*;
import java.util.function.IntFunction;

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
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new IntervalComparator());

        List<int[]> list = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right >= intervals[i][0] && left <= intervals[i][1]) {
                right = Math.max(intervals[i][1], right);
                left = Math.min(intervals[i][0], left);
            } else {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        list.add(new int[]{left, right});

        return list.toArray(new int[0][]);
    }

}
