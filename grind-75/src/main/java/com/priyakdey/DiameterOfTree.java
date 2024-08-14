package com.priyakdey;

import com.priyakdey.models.TreeNode;

public class DiameterOfTree {

    // https://leetcode.com/problems/diameter-of-binary-tree/

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int[] maxDiameter = {0};
        heights(root, maxDiameter);
        return maxDiameter[0];
    }

    private int heights(TreeNode node, int[] maxDiameter) {
        if (node.left == null && node.right == null) {
            return 1;
        }

        int leftHeight = 0, rightHeight = 0;

        if (node.left != null) {
            leftHeight = heights(node.left, maxDiameter);
        }

        if (node.right != null) {
            rightHeight = heights(node.right, maxDiameter);
        }

        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
