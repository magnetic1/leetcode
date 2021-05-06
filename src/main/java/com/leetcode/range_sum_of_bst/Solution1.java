/**
 * Leetcode - range_sum_of_bst
 */
package com.leetcode.range_sum_of_bst;
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int ans = 0, val = node.val;

        if (val < low) {
            ans += dfs(node.right, low, high);
        } else if (val == low) {
            ans += val;
            ans += dfs(node.right, low, high);
        } else if (val < high) {
            ans += val;
            ans += dfs(node.left, low, high);
            ans += dfs(node.right, low, high);
        } else if (val == high) {
            ans += val;
            ans += dfs(node.left, low, high);
        } else {
            ans += dfs(node.left, low, high);
        }

        return ans;
    }

}
