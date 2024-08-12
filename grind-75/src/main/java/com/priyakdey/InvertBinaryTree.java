package com.priyakdey;

import com.priyakdey.models.TreeNode;

public class InvertBinaryTree {

    // https://leetcode.com/problems/invert-binary-tree/description/

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

}
