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
class Solution1 implements Solution {
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            min = root.val;
            max = root.val;
            return true;
        } else if (root.left == null) {
            if (isValidBST(root.right) && root.val < min) {
                min = root.val;
                return true;
            }
            return false;
        }
        if (root.right == null) {
            if (isValidBST(root.left) && root.val > max) {
                max = root.val;
                return true;
            }
            return false;
        }


        if (isValidBST(root.left)) {
            int l_max = max;
            int l_min = min;
            if (isValidBST(root.right)) {
                int r_max = max;
                int r_min = min;
                max = r_max;
                min = l_min;
                return (l_max < root.val && r_min > root.val);
            }
        }

        return false;
    }

}
