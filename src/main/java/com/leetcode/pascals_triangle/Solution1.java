/**
 * Leetcode - pascals_triangle
 */
package com.leetcode.pascals_triangle;
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
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(numRows < 1) {
            return res;
        }

        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        res.add(l);

        for(int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for(int j = 1; j < i; j++) {
                List<Integer> ll = res.get(i-1);
                list.add(ll.get(j-1) + ll.get(j));
            }
            list.add(1);

            res.add(list);
        }

        return res;
    }
}
