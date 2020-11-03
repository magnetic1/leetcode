/**
 * Leetcode - binary_tree_preorder_traversal
 */
package com.leetcode.binary_tree_preorder_traversal;
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        TreeNode p1 = root, p2 = null;

        while(p1 != null) {
            p2 = p1.left;

            if(p2 != null) {
                while(p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }

                if(p2.right == null) {
                    ret.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                ret.add(p1.val);
            }

            p1 = p1.right;
        }
        return ret;
    }

}
