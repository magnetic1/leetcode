/**
 * Leetcode - design_hashset
 */
package com.leetcode.design_hashset;
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

    static class MyHashSet {
        Map<Integer, Integer> map;
        /** Initialize your data structure here. */
        public MyHashSet() {
            map = new HashMap<>();
        }

        public void add(int key) {
            if(!map.containsKey(key)) {
                map.put(key, 0);
            }
        }

        public void remove(int key) {
            map.remove(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return map.containsKey(key);
        }
    }

}
