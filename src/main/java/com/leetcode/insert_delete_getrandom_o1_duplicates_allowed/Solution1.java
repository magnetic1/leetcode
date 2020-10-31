/**
 * Leetcode - insert_delete_getrandom_o1_duplicates_allowed
 */
package com.leetcode.insert_delete_getrandom_o1_duplicates_allowed;

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

    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /**
     * Initialize your data structure here.
     */
    public Solution1() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        nums.add(val);

        Set<Integer> set;
        set = idx.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1);
        idx.put(val, set);

        return set.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }

        int i = idx.get(val).iterator().next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);

        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }

}
