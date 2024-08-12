package com.priyakdey;

import com.priyakdey.models.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode smallest = p.val < q.val ? p : q;
        TreeNode largest = p.val > q.val ? p : q;

        if (smallest.val < root.val && largest.val > root.val) {
            return root;
        }

        if (smallest.val == root.val) {
            return smallest;
        }
        if (largest.val == root.val) {
            return largest;
        }

        if (largest.val < root.val) {
            return lowestCommonAncestor(root.left, smallest, largest);
        } else {
            return lowestCommonAncestor(root.right, smallest, largest);
        }
    }

}
