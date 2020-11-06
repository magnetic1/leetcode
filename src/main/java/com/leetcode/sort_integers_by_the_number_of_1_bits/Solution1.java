/**
 * Leetcode - sort_integers_by_the_number_of_1_bits
 */
package com.leetcode.sort_integers_by_the_number_of_1_bits;
import java.util.*;
import java.util.stream.Collectors;

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

    public int[] sortByBits(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((i, j) -> {
            int counti = count_bits(i), countj = count_bits(j);
            return counti == countj ? i - j : counti - countj;
        });

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    int count_bits(int x) {
        int xx = x;
        xx = xx - ((xx >> 1) & 0x55555555);
        xx = (xx & 0x33333333) + ((xx >> 2) & 0x33333333);
        xx = (xx + (xx >> 4)) & 0x0f0f0f0f;
        xx = xx + (xx >> 8);
        return (xx + (xx >> 16)) & 0xff;
    }

}
