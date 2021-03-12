/**
 * Leetcode - verify_preorder_serialization_of_a_binary_tree
 */
package com.leetcode.verify_preorder_serialization_of_a_binary_tree;
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

    int i = 0;
    int n;
    public boolean isValidSerialization(String preorder) {
        n = preorder.length();
        if(n == 1) {
            return preorder.charAt(0) == '#' ;
        }

        return isValid(preorder) && i >= n;
    }

    boolean isValid(String preorder) {
        if(i >= n) {
            return false;
        }
        char c = preorder.charAt(i);
        if(c == '#') {
            i += 2;
            return true;
        }

        i++;
        while(i < n && (c = preorder.charAt(i)) >= '0' && c <='9') {
            i++;
        }

        if(i == n) {
            return true;
        }
        i += 1;
        return isValid(preorder) && isValid(preorder);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

}
