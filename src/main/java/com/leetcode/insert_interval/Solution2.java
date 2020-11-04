/**
 * Leetcode - insert_interval
 */
package com.leetcode.insert_interval;
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

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int r = -1, l = intervals.length;
        int min = newInterval[0], max = newInterval[1];

        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0]) {
                r = i;
            } else if(intervals[i][0] > newInterval[1]) {
                l = i;
                break;
            }
        }

        if(l - r < 2) {
            int[][] new_intervals = new int[intervals.length + 1][2];
            System.arraycopy(intervals, 0, new_intervals, 0, r + 1);
            System.arraycopy(intervals, l, new_intervals, l + 1, intervals.length - l);
            new_intervals[l][0] = min; new_intervals[l][1] = max;
            return new_intervals;
        } else {
            min = Math.min(min, intervals[r + 1][0]);
            max = Math.max(max, intervals[l - 1][1]);

            int len = intervals.length - l + r + 2;

            int[][] new_intervals = new int[len][2];
            System.arraycopy(intervals, 0, new_intervals, 0, r + 1);
            System.arraycopy(intervals, l, new_intervals, r + 2, intervals.length - l);
            new_intervals[r+1][0] = min; new_intervals[r+1][1] = max;
            return new_intervals;
        }

    }

}
