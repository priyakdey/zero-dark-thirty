package com.priyakdey.design;

public class WordDictionary {
    // https://leetcode.com/problems/design-add-and-search-words-data-structure/

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        if (word.isEmpty()) {
            throw new IllegalArgumentException("invalid input");
        }

        Node curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            throw new IllegalArgumentException("invalid input");
        }

        return search(root, word, 0);
    }

    private boolean search(Node curr, String s, int index) {
        if (index == s.length()) {
            return curr.end;
        }

        char ch = s.charAt(index);
        if (ch == '.') {
            for (Node child : curr.children) {
                if (child != null) {
                    if (search(child, s, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int i = ch - 'a';
            if (curr.children[i] == null) {
                return false;
            }
            return search(curr.children[i], s, index + 1);
        }
    }

    private static class Node {
        final Node[] children;
        boolean end;

        public Node() {
            this.children = new Node[26];
            this.end = false;
        }
    }
}