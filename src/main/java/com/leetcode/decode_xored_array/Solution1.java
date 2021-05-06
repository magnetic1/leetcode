/**
 * Leetcode - decode_xored_array
 */
package com.leetcode.decode_xored_array;
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

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] arr = new int[len + 1];

        arr[0] = first;
        for (int i = 0; i < len; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }

        return arr;
    }

}
