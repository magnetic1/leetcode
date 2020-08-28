/**
 * Leetcode - binary_tree_inorder_traversal
 */
package com.leetcode.binary_tree_inorder_traversal;
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        search(ret, root);

        return ret;
    }

    void search(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        search(list, node.left);
        list.add(node.val);
        search(list, node.right);
    }

}
