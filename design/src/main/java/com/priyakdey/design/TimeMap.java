package com.priyakdey.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TimeMap {
    // https://leetcode.com/problems/time-based-key-value-store/

    private final Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = map.get(key);
        int index = findIndex(pairs, timestamp);
        return index != -1 ? pairs.get(index).value : "";
    }

    private int findIndex(List<Pair> list, int timestamp) {
        int index = -1;
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }


    private record Pair(int timestamp, String value) {
    }
}
