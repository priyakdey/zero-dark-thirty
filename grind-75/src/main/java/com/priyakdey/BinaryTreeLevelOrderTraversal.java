package com.priyakdey;

import com.priyakdey.models.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        if (root.left == null && root.right == null) return List.of(List.of(root.val));

        List<List<Integer>> levels = new ArrayList<>();
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            if (level >= levels.size()) {
                levels.add(new ArrayList<>());
            }
            levels.get(level).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }

        return levels;
    }

    private record Pair(TreeNode node, int level) {
    }

}
