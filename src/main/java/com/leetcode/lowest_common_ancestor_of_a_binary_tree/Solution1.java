/**
 * Leetcode - lowest_common_ancestor_of_a_binary_tree
 */
package com.leetcode.lowest_common_ancestor_of_a_binary_tree;

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

    int n = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (n == 2) {
            return null;
        }
        if (root == p || root == q) {
            n++;
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);
            if (lNode != null && rNode != null)
                return root;
            else if (lNode == null) {//两个都在右子树
                return rNode;
            } else { //两个都在左子树里面
                return lNode;
            }
        }
        return null;
    }

}
