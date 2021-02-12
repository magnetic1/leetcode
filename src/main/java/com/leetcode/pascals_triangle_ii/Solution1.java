/**
 * Leetcode - pascals_triangle_ii
 */
package com.leetcode.pascals_triangle_ii;
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

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int size = 0;  size <= rowIndex; size++) {
            for(int i = size - 1; i > 0; i--) {
                list.set(i, list.get(i - 1) + list.get(i));
            }
            list.add(1);
        }

        return list;
    }
}
