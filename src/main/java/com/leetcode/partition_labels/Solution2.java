/**
 * Leetcode - partition_labels
 */
package com.leetcode.partition_labels;
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

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] ends = new int[26];
        int n = S.length();

        for(int i = 0; i < n; i++) {
            char c = S.charAt(i);
            ends[c - 'a'] = i;
        }

        int start = 0, end = 0;
        for(int i = 0; i < n; i++) {
            char c = S.charAt(i);
            end = Math.max(end, ends[c - 'a']);
            if(i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

}
