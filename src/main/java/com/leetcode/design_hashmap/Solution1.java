/**
 * Leetcode - design_hashmap
 */
package com.leetcode.design_hashmap;
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

    static class MyHashMap {
        static class Pair {
            private final int key;
            private int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        private static final int BASE = 769;
        private final List<LinkedList<Pair>> data;

        /** Initialize your data structure here. */
        public MyHashMap() {
            data = new ArrayList<>(BASE);
            for(int i = 0; i < BASE; i++) {
                data.add(new LinkedList<>());
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = hash(key);
            LinkedList<Pair> pairLinkedList = data.get(hash);

            for(Pair pair : pairLinkedList) {
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            pairLinkedList.addLast(new Pair(key, value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            LinkedList<Pair> pairLinkedList = data.get(hash(key));

            for(Pair pair : pairLinkedList) {
                if (pair.getKey() == key) {
                    return pair.getValue();
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            LinkedList<Pair> pairLinkedList = data.get(hash(key));

            for(Pair pair : pairLinkedList) {
                if (pair.getKey() == key) {
                    pairLinkedList.remove(pair);
                    return;
                }
            }
        }

        private int hash(int v) {
            return v % BASE;
        }
    }

}
