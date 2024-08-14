package com.priyakdey;

import java.util.*;

public class CloneGraph {

    // https://leetcode.com/problems/clone-graph/

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Map<Node, Node> nodeMappings = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();

        Node nodeClone = new Node(node.val, new ArrayList<>());
        nodeMappings.put(node, nodeClone);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!nodeMappings.containsKey(neighbor)) {
                    Node newNode = new Node(neighbor.val, new ArrayList<>());
                    nodeMappings.put(neighbor, newNode);
                    queue.offer(neighbor);
                }
                nodeMappings.get(current).neighbors.add(nodeMappings.get(neighbor));
            }
        }

        return nodeClone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
