/**
 * Leetcode - best_time_to_buy_and_sell_stock
 */
package com.leetcode.best_time_to_buy_and_sell_stock;

import java.util.*;

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

    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = i;
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

}
