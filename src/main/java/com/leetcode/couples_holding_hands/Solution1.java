/**
 * Leetcode - couples_holding_hands
 */
package com.leetcode.couples_holding_hands;

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

    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < row.length; i++) {
            int person = row[i];
            int num = person / 2;
            if (numToIndex.containsKey(num)) {
                int index = numToIndex.get(num);
                if (index == i / 2) {
                    continue;
                }
                if (row[index * 2] / 2 == num) {
                    swap(row, index * 2 + 1, i);
                } else {
                    swap(row, index * 2, i);
                }
                numToIndex.remove(row[i] / 2);
                ret++;
                i--;
            } else {
                numToIndex.put(num, i / 2);
            }
        }

        return ret;
    }

    void swap(int[] row, int i, int j) {
        int t = row[i];
        row[i] = row[j];
        row[j] = t;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.minSwapsCouples(new int[]{
                0, 2, 1, 3
        });
    }
}
