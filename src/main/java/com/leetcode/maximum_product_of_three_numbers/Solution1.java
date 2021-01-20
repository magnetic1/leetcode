/**
 * Leetcode - maximum_product_of_three_numbers
 */
package com.leetcode.maximum_product_of_three_numbers;

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

    int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

    public int maximumProduct(int[] nums) {
        for (int v : nums) {
            addToMax(v);
            addToMin(v);
        }

        return Math.max(max[0] * max[1] * max[2], min[0] * min[1] * max[0]);
    }

    void addToMax(int v) {
        int len = 3;
        int index = len;
        while (index > 0) {
            if (v > max[index - 1]) {
                index--;
            } else {
                break;
            }
        }
        if (len - 1 - index >= 0) {
            System.arraycopy(max, index, max, index + 1, len - 1 - index);
        }
        if (index < len) {
            max[index] = v;
        }
    }

    void addToMin(int v) {
        int len = 2;
        int index = len;
        while (index > 0) {
            if (v < min[index - 1]) {
                index--;
            } else {
                break;
            }
        }
        if (len - 1 - index >= 0) {
            System.arraycopy(min, index, min, index + 1, len - 1 - index);
        }
        if (index < len) {
            min[index] = v;
        }
    }

}
