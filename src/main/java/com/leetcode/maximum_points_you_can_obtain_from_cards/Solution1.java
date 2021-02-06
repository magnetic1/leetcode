/**
 * Leetcode - maximum_points_you_can_obtain_from_cards
 */
package com.leetcode.maximum_points_you_can_obtain_from_cards;
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

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int min = 0, size = n - k;
        for(int i = 0; i < size; i++) {
            min += cardPoints[i];
        }
        int sum = min;
        for(int i = size; i < n; i++) {
            sum += cardPoints[i];
        }

        int value = min;
        for(int i = size; i < n; i++) {
            value = value - cardPoints[i - size] + cardPoints[i];
            min = Math.min(min, value);
        }

        return sum - min;
    }

}
