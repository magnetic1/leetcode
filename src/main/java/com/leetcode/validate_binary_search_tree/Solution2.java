/**
 * Leetcode - validate_binary_search_tree
 */
package com.leetcode.validate_binary_search_tree;

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
class Solution2 implements Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode node, TreeNode lower, TreeNode upper) {
        if (node == null)
            return true;
        if (lower != null && lower.val >= node.val)
            return false;
        if (upper != null && upper.val <= node.val)
            return false;
        return helper(node.left, lower, node) && helper(node.right, node, upper);
    }


    public boolean isValidBST1(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateBST(TreeNode root, long min, long max) {
        return root == null ||
                (root.val > min && root.val < max)
                        && validateBST(root.left, min, root.val)
                        && validateBST(root.right, root.val, max);
    }

}
