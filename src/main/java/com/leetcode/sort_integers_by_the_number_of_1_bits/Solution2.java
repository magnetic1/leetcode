/**
 * Leetcode - sort_integers_by_the_number_of_1_bits
 */
package com.leetcode.sort_integers_by_the_number_of_1_bits;
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

    public int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = (count_bits(arr[i]) << 16) + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % (1 << 16);
        }
        return map;
    }

    int count_bits(int xx) {
        xx = xx - ((xx >> 1) & 0x55555555);
        xx = (xx & 0x33333333) + ((xx >> 2) & 0x33333333);
        xx = (xx + (xx >> 4)) & 0x0f0f0f0f;
        xx = xx + (xx >> 8);
        return (xx + (xx >> 16)) & 0xff;
    }
}
