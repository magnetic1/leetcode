/**
 * Leetcode - serialize_and_deserialize_binary_tree
 */
package com.leetcode.serialize_and_deserialize_binary_tree;
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if(root != null) {
            Deque<TreeNode> parents = new LinkedList<>();
            parents.offer(root.left);
            parents.offer(root.right);

            sb.append(root.val);

            serialize(sb, parents);
        }
        sb.append(']');

        return sb.toString();
    }

    void serialize(StringBuilder sb, Deque<TreeNode> parents) {
        int size = parents.size();
        if(size == 0) {
            return;
        }

        while(!parents.isEmpty()) {
            TreeNode node = parents.poll();
            if(node == null) {
                sb.append(',').append("null");
            } else {
                sb.append(',').append(node.val);
                parents.offer(node.left);
                parents.offer(node.right);
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str = data.substring(1, data.length() - 1);
        String[] values = str.split(",");

        if(values.length == 0 || values[0].equals("")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Deque<TreeNode> parents = new LinkedList<>();
        parents.offer(root);

        int i = 1;
        while(!parents.isEmpty() || i < values.length) {
            String val = values[i];
            TreeNode node = parents.poll();

            if(!val.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(val));
                parents.offer(node.left);
            }
            val = values[i + 1];
            if(!val.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(val));
                parents.offer(node.right);
            }

            i = i + 2;
        }

        return root;
    }
}