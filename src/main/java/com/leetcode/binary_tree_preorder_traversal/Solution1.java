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
class Solution1 implements Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        search(ret, root);
        return ret;
    }

    private void search(List<Integer> ret, TreeNode node) {
        if (node == null) {
            return;
        }
        ret.add(node.val);
        search(ret, node.left);
        search(ret, node.right);
    }

}
