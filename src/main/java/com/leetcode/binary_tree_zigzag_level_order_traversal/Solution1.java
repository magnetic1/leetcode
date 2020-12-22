/**
 * Leetcode - binary_tree_zigzag_level_order_traversal
 */
package com.leetcode.binary_tree_zigzag_level_order_traversal;
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        if(root == null) {
            return ret;
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        readOrder(list, ret, true);
        return ret;
    }

    void readOrder(List<TreeNode> nodes, List<List<Integer>> ret, boolean isLeft) {
        List<Integer> list = new ArrayList<>();
        for(TreeNode node : nodes) {
            list.add(node.val);
        }
        ret.add(list);

        List<TreeNode> next = new ArrayList<>();
        for(int i = nodes.size() - 1; i >= 0; i--) {
            TreeNode node = nodes.get(i);

            if (isLeft && node.right != null) {
                next.add(node.right);
            }
            if(node.left != null) {
                next.add(node.left);
            }
            if (!isLeft && node.right != null) {
                next.add(node.right);
            }
        }

        if(next.size() > 0) {
            readOrder(next, ret, !isLeft);
        }
    }

}
