/**
 * Leetcode - flatten_nested_list_iterator
 */
package com.leetcode.flatten_nested_list_iterator;

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

    static class NestedIterator implements Iterator<Integer> {
        Iterator<Integer> iter;
        List<Integer> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            addToList(nestedList);
            iter = list.iterator();
        }

        void addToList(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    list.add(ni.getInteger());
                } else {
                    addToList(ni.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }
    }

}
