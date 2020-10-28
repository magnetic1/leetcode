/**
 * Leetcode - unique_number_of_occurrences
 */
package com.leetcode.unique_number_of_occurrences;
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

    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[1001];

        Map<Integer, Integer> map = new HashMap<>();
        for(int v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        for(int value : map.values()) {
            if(count[value] != 0) {
                return false;
            }
            count[value] = 1;
        }

        return true;
    }

}
