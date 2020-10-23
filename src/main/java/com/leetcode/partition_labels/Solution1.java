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
class Solution1 implements Solution {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> count = new HashMap<>();
        int n = S.length();

        for(int i = 0; i < n; i++) {
            char c = S.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tmp = new HashMap<>();
        int last = -1;
        for(int i = 0; i < n; i++) {
            char c = S.charAt(i);
            int num = tmp.getOrDefault(c, 0) + 1;
            tmp.put(c, num);
            if(num == count.get(c) && check(tmp, count)) {
                res.add(i - last);
                last = i;
                tmp = new HashMap<>();
            }
        }

        return res;
    }

    boolean check(Map<Character, Integer> tmp, Map<Character, Integer> count) {
        for(Character c : tmp.keySet()){
            if(!tmp.get(c).equals(count.get(c))) {
                return false;
            }
        }
        return true;
    }

}
