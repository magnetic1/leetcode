/**
 * Leetcode - minimum_distance_between_bst_nodes
 */
package com.leetcode.minimum_distance_between_bst_nodes;
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

    int ans = Integer.MAX_VALUE;
    int pre = -10_0000;

    public int minDiffInBST(TreeNode root) {
        search(root);
        return ans;
    }

    void search(TreeNode node) {
        if (node.left != null) {
            search(node.left);
        }

        ans = Math.min(ans, node.val - pre);
        pre = node.val;

        if (node.right != null) {
            search(node.right);
        }
    }

}
