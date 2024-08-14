package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class Trie {

    private final Node root;

    public Trie() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }

        Node curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node(ch);
            }
            curr = curr.children[index];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return false;
        }

        Node node = findNode(word);
        if (node == null) {
            return false;
        }

        return node.end;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        return findNode(prefix) != null;
    }

    private Node findNode(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }

        return curr;
    }

    private static class Node {
        char ch;
        Node[] children;
        boolean end;

        Node(char ch) {
            this.ch = ch;
            this.children = new Node[26];
            this.end = false;
        }

    }

}
