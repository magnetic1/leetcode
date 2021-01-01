/**
 * Leetcode - non_overlapping_intervals
 */
package com.leetcode.non_overlapping_intervals;
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
class Solution1 implements Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int ret = 0, last = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[last][1]) {
                ret++;
            } else {
                last = i;
            }
        }

        return ret;
    }

}
