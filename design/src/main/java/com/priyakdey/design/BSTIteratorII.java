package com.priyakdey.design;

import com.priyakdey.design.models.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class BSTIteratorII {
    // https://leetcode.com/problems/binary-search-tree-iterator-ii/

    private final Deque<Pair> fwdStack;
    private final Deque<Pair> backStack;

    public BSTIteratorII(TreeNode root) {
        this.fwdStack = new ArrayDeque<>();
        this.backStack = new ArrayDeque<>();

        TreeNode curr = root;
        TreeNode parent = null;

        while (curr != null) {
            fwdStack.push(new Pair(curr, parent));
            parent = curr;
            curr = curr.left;
        }
    }

    public boolean hasNext() {
        return !fwdStack.isEmpty();
    }

    public int next() {
        Pair pair = fwdStack.pop();
        backStack.push(pair);

        TreeNode curr = pair.node.right;
        TreeNode parent = pair.node;
        while (curr != null) {
            fwdStack.push(new Pair(curr, parent));
            parent = curr;
            curr = curr.left;
        }
        return pair.node.val;
    }

    public boolean hasPrev() {
        return !backStack.isEmpty();
    }

    public int prev() {
        Pair pair = backStack.pop();
        while (!fwdStack.isEmpty() && pair.node != fwdStack.peek().parent) {
            fwdStack.pop();
        }

        fwdStack.push(pair);
        return backStack.peek().node.val;
    }

    private record Pair(TreeNode node, TreeNode parent) {
    }
}
