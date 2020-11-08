/**
 * Leetcode - best_time_to_buy_and_sell_stock_ii
 */
package com.leetcode.best_time_to_buy_and_sell_stock_ii;
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

    public int maxProfit(int[] prices) {
        int res = 0, price = 0;
        for(int i = 0; i < prices.length; i++) {
            if(isBottom(prices, i)) {
                price = prices[i];
                for(i = i + 1;i < prices.length; i++) {
                    if(isTop(prices, i)) {
                        res += prices[i] - price;
                        break;
                    }
                }
            }
        }
        return res;
    }

    boolean isTop(int[] prices, int i) {
        if(i < prices.length - 1) {
            return prices[i] > prices[i + 1];
        }
        return true;
    }

    boolean isBottom(int[] prices, int i) {
        if (i < prices.length - 1) {
            return prices[i] < prices[i + 1];
        }
        return true;
    }

}
