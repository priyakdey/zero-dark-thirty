package com.priyakdey.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class FileSystem {
    // https://leetcode.com/problems/design-file-system/

    private final Node root;

    public FileSystem() {
        this.root = new Node("", -1, new ArrayList<>());
    }

    public boolean createPath(String path, int value) {
        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("Path must start with '/'");
        }

        path = path.substring(1);
        String[] paths = path.split("/");
        Node curr = root;

        for (int i = 0; i < paths.length - 1; i++) {
            String _path = paths[i];
            Node child = null;
            for (Node _child : curr.children) {
                if (Objects.equals(_child.name, _path)) {
                    child = _child;
                    break;
                }
            }

            if (child == null) {
                return false;
            }
            curr = child;
        }

        String pathName = paths[paths.length - 1];
        for (Node _child : curr.children) {
            if (Objects.equals(_child.name, pathName)) {
                return false;
            }
        }

        curr.children.add(new Node(pathName, value, new ArrayList<>()));
        return true;
    }

    public int get(String path) {
        if (!path.startsWith("/")) {
            return -1;
        }

        path = path.substring(1);
        String[] paths = path.split("/");
        Node curr = root;

        for (String _path : paths) {
            Node child = null;
            for (Node _child : curr.children) {
                if (Objects.equals(_child.name, _path)) {
                    child = _child;
                    break;
                }
            }

            if (child == null) {
                return -1;
            }
            curr = child;
        }

        return curr.value;
    }

    private record Node(String name, int value, List<Node> children) {
    }
}