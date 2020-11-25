/**
 * Leetcode - count_complete_tree_nodes
 */
package com.leetcode.count_complete_tree_nodes;
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

    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
