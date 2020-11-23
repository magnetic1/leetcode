/**
 * Leetcode - minimum_number_of_arrows_to_burst_balloons
 */
package com.leetcode.minimum_number_of_arrows_to_burst_balloons;
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

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 1)  return 1;
        int count = n;
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[0], b[0]);     //排序后则不用考虑左边界，只需考虑右边界
        });

        for(int i = 1; i < n; i++){
            if(points[i][0] <= points[i-1][1]){   //区间相交
                if(points[i][1] <= points[i-1][1]){
                    count--;
                }else{
                    points[i][1] = points[i-1][1]; //缩小边界
                    count--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.findMinArrowShots(new int[][] {
                {10,16},{2,8},{1,6},{7,12}
        });
    }

}
