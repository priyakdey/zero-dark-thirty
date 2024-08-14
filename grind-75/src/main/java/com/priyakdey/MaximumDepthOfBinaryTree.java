package com.priyakdey;

import com.priyakdey.models.TreeNode;

public class MaximumDepthOfBinaryTree {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
