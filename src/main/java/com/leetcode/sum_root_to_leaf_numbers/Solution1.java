/**
 * Leetcode - sum_root_to_leaf_numbers
 */
package com.leetcode.sum_root_to_leaf_numbers;
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

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int num) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return num * 10 + node.val;
        }

        num = num * 10 + node.val;
        return dfs(node.left, num) + dfs(node.right, num);
    }

}
