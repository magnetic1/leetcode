/**
 * Leetcode - combinations
 */
package com.leetcode.combinations;
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
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combine(res, list, 1, n, k);
        return res;
    }

    private void combine(List<List<Integer>> res, List<Integer> list, int i, int n, int k) {
        if (k == 0) {
            res.add(list);
            return;
        }
        if (i + k > n + 1) {
            return;
        }

        combine(res, new ArrayList<>(list), i + 1, n, k);
        list.add(i);
        combine(res, new ArrayList<>(list), i + 1, n, k - 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.combine(4, 2);
    }
}
