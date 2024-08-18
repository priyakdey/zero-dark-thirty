package com.priyakdey.design;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    // https://leetcode.com/problems/design-an-ordered-stream/

    private final String[] stream;
    private int index;

    public OrderedStream(int n) {
        this.stream = new String[n];
        this.index = 0;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        stream[idKey - 1] = value;
        while (index < stream.length && stream[index] != null) {
            result.add(stream[index++]);
        }

        return result;
    }
}