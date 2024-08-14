package com.priyakdey;

import com.priyakdey.models.TreeNode;

/**
 * @author Priyak Dey
 */
public class ValidateBinarySearchTree {

    // Given the root of a binary tree, determine if it is a valid binary
    // search tree (BST).
    //
    // A valid BST is defined as follows:
    //
    // - The left subtree of a node contains only nodes with keys less than
    //   the node's key.
    // - The right subtree of a node contains only nodes with keys greater
    //   than the node's key.
    // - Both the left and right subtrees must also be binary search trees.

    public boolean isValidBST(TreeNode root) {
        return isValidBSTNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTNode(TreeNode node, long lowerBound, long upperBound) {
        if (node == null) return true;
        return node.val > lowerBound && node.val < upperBound
                && isValidBSTNode(node.left, lowerBound, node.val)
                && isValidBSTNode(node.right, node.val, upperBound);
    }


}
