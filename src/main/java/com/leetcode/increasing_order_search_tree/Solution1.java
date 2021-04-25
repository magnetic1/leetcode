/**
 * Leetcode - increasing_order_search_tree
 */
package com.leetcode.increasing_order_search_tree;
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

    public TreeNode increasingBST(TreeNode root) {
        TreeNode pre = new TreeNode(0);
        dfs(pre, root);

        return pre.right;
    }

    TreeNode dfs(TreeNode parent, TreeNode node) {
        if (node == null) {
            return parent;
        }
        parent = dfs(parent, node.left);

        parent.right = node;
        node.left = null;

        parent = dfs(node, node.right);

        return parent;
    }

}
