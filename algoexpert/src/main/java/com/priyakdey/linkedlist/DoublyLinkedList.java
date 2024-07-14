package com.priyakdey.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 14-07-2024
 */
public class DoublyLinkedList {

    // Write a DoublyLinkedList class that has a head and a tail, both of which point to either a
    // linked list Node or None / null. The class should support:
    //
    // - Setting the head and tail of the linked list.
    // - Inserting nodes before and after other nodes as well as at given positions (the position
    // of the head node is 1).
    // - Removing given nodes and removing nodes with given values.
    // - Searching for nodes with given values.
    //
    // Note that the setHead, setTail, insertBefore, insertAfter, insertAtPosition, and remove
    // methods all take in actual Nodes as input parameters—not integers (except for
    // insertAtPosition, which also takes in an integer representing the position); this means
    // that you don't need to create any new Nodes in these methods. The input nodes can be
    // either stand-alone nodes or nodes that are already in the linked list. If they're nodes
    // that are already in the linked list, the methods will effectively be moving the nodes
    // within the linked list. You won't be told if the input nodes are already in the linked
    // list, so your code will have to defensively handle this scenario.
    // If you're doing this problem in an untyped language like Python or JavaScript, you may
    // want to look at the various function signatures in a typed language like Java or
    // TypeScript to get a better idea of what each input parameter is.
    //
    // Each Node has an integer value as well as a prev node and a next node, both of which can
    // point to either another node or None / null.

    private final Set<Node> nodes = new HashSet<>();
    public Node head;
    public Node tail;
    private int size;

    public void setHead(Node node) {
        if (size == 0) {
            this.head = node;
            this.tail = node;
            size++;
        } else if (!nodes.contains(node)) {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            size++;
        } else {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;

            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            node.prev = null;
        }
        nodes.add(node);
    }


    public void setTail(Node node) {
        if (size == 0) {
            this.head = node;
            this.tail = node;
            size++;
        } else if (!nodes.contains(node)) {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
            size++;
        } else {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;

            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
            node.next = null;
        }
        nodes.add(node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        if (node == this.head) {
            this.setHead(nodeToInsert);
        } else {
            if (nodes.contains(nodeToInsert)) {
                nodeToInsert.prev.next = nodeToInsert.next;
                nodeToInsert.next.prev = nodeToInsert.prev;
            } else {
                size++;
                nodes.add(node);
            }
            Node prev = node.prev;
            prev.next = nodeToInsert;
            nodeToInsert.next = node;
            node.prev = nodeToInsert;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        // Write your code here.
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        // Write your code here.
    }

    public void removeNodesWithValue(int value) {
        // Write your code here.
    }

    public void remove(Node node) {
        // Write your code here.
    }

    public boolean containsNodeWithValue(int value) {
        // Write your code here.
        return false;
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}
