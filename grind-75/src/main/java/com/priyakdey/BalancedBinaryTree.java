package com.priyakdey;

import com.priyakdey.models.TreeNode;

public class BalancedBinaryTree {

    // https://leetcode.com/problems/balanced-binary-tree/

    public boolean isBalanced(TreeNode root) {
        int[] maxDiffRef = {0};
        isBalanced(root, maxDiffRef);
        return maxDiffRef[0] <= 1;
    }

    private int isBalanced(TreeNode node, int[] maxDiffRef) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int leftSubtreeHeight  = isBalanced(node.left, maxDiffRef);
        int rightSubtreeHeight = isBalanced(node.right, maxDiffRef);

        maxDiffRef[0] = Math.max(maxDiffRef[0], Math.abs(leftSubtreeHeight - rightSubtreeHeight));

        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

}
