package com.priyakdey;

import com.priyakdey.models.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class KthSmallestElementInABST {

    // Given the root of a binary search tree, and an integer k, return the
    // kth smallest value (1-indexed) of all the values of the nodes in the
    // tree.

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            throw new IllegalArgumentException("invalid input");
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty() && k > 0) {
            curr = stack.pop();
            k--;

            TreeNode child = curr.right;
            while (child != null) {
                stack.push(child);
                child = child.left;
            }
        }

        if (k != 0) {
            throw new IllegalArgumentException("not enough nodes");
        }

        return curr.val;
    }
}
