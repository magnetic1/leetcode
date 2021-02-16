/**
 * Leetcode - largest_rectangle_in_histogram
 */
package com.leetcode.largest_rectangle_in_histogram;
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

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        int n = heights.length;
        int[] up = new int[n];
        int[] down = new int[n];

        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.poll();
            }
            up[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }
        deque.clear();

        for(int i = n - 1; i >= 0; i--) {
            while(!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.poll();
            }
            down[i] = deque.isEmpty() ? n : deque.peek();
            deque.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            int width = down[i] - up[i] - 1;
            ans = Math.max(ans, heights[i] * width);
        }

        return ans;
    }

}
