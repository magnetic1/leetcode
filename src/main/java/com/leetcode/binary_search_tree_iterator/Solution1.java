/**
 * Leetcode - binary_search_tree_iterator
 */
package com.leetcode.binary_search_tree_iterator;
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

    private static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now;

        public BSTIterator(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root);
        }

        void dfs(TreeNode node) {
            TreeNode left = node.left;
            if (left == null) {
                now = node;
            } else {
                stack.push(node);
                dfs(left);
            }
        }

        public int next() {
            int val = now.val;

            if (now.right != null) {
                dfs(now.right);
            } else if (!stack.isEmpty()) {
                now = stack.pop();
            } else {
                now = null;
            }

            return val;
        }

        public boolean hasNext() {
            return now != null;
        }
    }

}
