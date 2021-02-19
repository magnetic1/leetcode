/**
 * Leetcode - binary_tree_maximum_path_sum
 */
package com.leetcode.binary_tree_maximum_path_sum;
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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }

    int find(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = Math.max(find(node.left), 0);
        int right = Math.max(find(node.right), 0);

        int val = node.val;
        max = Math.max(max, val + left + right);

        return val + Math.max(right, left);
    }

}
