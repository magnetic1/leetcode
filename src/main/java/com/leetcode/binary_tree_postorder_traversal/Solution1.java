/**
 * Leetcode - binary_tree_postorder_traversal
 */
package com.leetcode.binary_tree_postorder_traversal;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        search(ret, root);
        return ret;
    }

    private void search(List<Integer> ret, TreeNode node) {
        if (node == null) {
            return;
        }
        search(ret, node.left);
        search(ret, node.right);
        ret.add(node.val);
    }


}
