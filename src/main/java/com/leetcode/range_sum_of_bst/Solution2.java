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
class Solution2 implements Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int ans = 0, val = node.val;

        if (low <= val && val <= high) {
            ans += val;
        }

        if (val < high) {
            ans += dfs(node.right, low, high);
        }

        if (val > low) {
            ans += dfs(node.left, low, high);
        }

        return ans;
    }

}
