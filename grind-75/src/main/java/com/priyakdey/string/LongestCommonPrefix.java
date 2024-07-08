package com.priyakdey.string;

import java.util.Arrays;

/**
 * @author Priyak Dey
 * @since 03-07-2024
 */
public class LongestCommonPrefix {

    // Write a function to find the longest common prefix string amongst an array of strings.
    // If there is no common prefix, return an empty string "".

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("invalida argument");
        }

        Trie trie = new Trie();
        Arrays.stream(strs).forEach(trie::add);
        return trie.prefix();
    }

    private static class Trie {
        private final Node root;

        private Trie() {
            this.root = new Node();
        }

        public void add(String word) {
            Node curr = this.root;
            for (char ch : word.toCharArray()) {
                int index = ch - 97;
                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }

            curr.terminal = true;
        }

        public String prefix() {
            StringBuilder buffer = new StringBuilder();
            dfs(this.root, buffer);
            return buffer.toString();
        }

        private void dfs(Node node, StringBuilder buffer) {
            if (node.terminal) {
                return;
            }

            Node child = null;

            for (int i = 0, childrenLength = node.children.length; i < childrenLength; i++) {
                if (node.children[i] != null) {
                    if (child == null) {
                        child = node.children[i];
                        buffer.appendCodePoint(i + 97);
                    } else {
                        // remove the char added
                        buffer.deleteCharAt(buffer.length() - 1);
                        return;
                    }
                }
            }

            if (child == null) return;

            dfs(child, buffer);
        }

    }

    private static class Node {
        private final Node[] children;
        private boolean terminal;

        private Node() {
            this.children = new Node[26];
        }
    }

}
