package com.priyakdey.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUnique {
    // https://leetcode.com/problems/first-unique-number/

    private final List<Integer> elements;
    private final Map<Integer, Integer> freqMap;

    public FirstUnique(int[] nums) {
        this.elements = new ArrayList<>(nums.length);
        this.freqMap = new HashMap<>();

        for (int num : nums) {
            elements.add(num);
            freqMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

    }
    
    public int showFirstUnique() {
        for (int element : elements) {
            if (freqMap.get(element) == 1) {
                return element;
            }
        }

        return -1;
    }
    
    public void add(int value) {
        this.elements.add(value);
        this.freqMap.compute(value, (k, v) -> v == null ? 1 : v + 1);
    }
}