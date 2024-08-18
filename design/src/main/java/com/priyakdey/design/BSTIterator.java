package com.priyakdey.design;


import com.priyakdey.design.models.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    // https://leetcode.com/problems/binary-search-tree-iterator/

    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode next = stack.pop();

        TreeNode curr = next.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        return next.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}