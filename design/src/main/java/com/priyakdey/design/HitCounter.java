package com.priyakdey.design;

import java.util.LinkedList;

public class HitCounter {
    // https://leetcode.com/problems/design-hit-counter/

    private final LinkedList<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        chopWindow(timestamp);
        hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        chopWindow(timestamp);
        return hits.size();
    }

    public void chopWindow(int timestamp) {
        int index = findIndex(timestamp);
        if (index != -1) {
            hits.subList(0, index + 1).clear();
        }
    }

    private int findIndex(int timestamp) {
        int t = timestamp - 300;

        int left = 0, right = hits.size() - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hits.get(mid) <= t) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}