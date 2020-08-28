/**
 * Leetcode - binary_tree_level_order_traversal
 */
package com.leetcode.binary_tree_level_order_traversal;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        search(ret, 0, root);

        return ret;
    }

    void search(List<List<Integer>> ret, int level, TreeNode node) {
        if (node == null) {
            return;
        }

        if (ret.size() == level) {
            ret.add(new ArrayList<>());
        }

        ret.get(level).add(node.val);
        search(ret, level + 1, node.left);
        search(ret, level + 1, node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        Solution1 solution = new Solution1();
        solution.levelOrder(root);
    }
}
