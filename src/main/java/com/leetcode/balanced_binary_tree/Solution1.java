/**
 * Leetcode - balanced_binary_tree
 */
package com.leetcode.balanced_binary_tree;
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
    int depth = 0;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            depth = 0;
            return true;
        }

        if (isBalanced(root.left)) {
            int left = depth;
            if (isBalanced(root.right)) {
                int right = depth;

                depth = Math.max(right, left) + 1;
                return (right - left <= 1) && (left - right <= 1);
            }
        }
        return false;
    }
}
