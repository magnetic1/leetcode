/**
 * Leetcode - Wildcard_Matching
 */
package com.leetcode.Wildcard_Matching;
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


    public boolean isMatch(String s, String p) {

        return false;
    }



    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isMatch(
                "aa" ,
                "*"));
    }

}
