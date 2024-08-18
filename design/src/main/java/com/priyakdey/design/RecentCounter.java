package com.priyakdey.design;

import java.util.LinkedList;

public class RecentCounter {
    // https://leetcode.com/problems/number-of-recent-calls/

    private final LinkedList<Integer> pings;

    public RecentCounter() {
        pings = new LinkedList<>();
    }

    public int ping(int t) {
        int index = findIndex(t - 3000);
        if (index != -1) {
            pings.subList(0, index).clear();
        }
        pings.add(t);
        return pings.size();
    }

    /**
     * Returns the leftmost index of timestamp or next greater value.
     *
     * @param timestamp int
     * @return index
     */
    private int findIndex(int timestamp) {
        if (pings.isEmpty()) return -1;
        if (timestamp <= pings.getFirst()) return -1;
        if (timestamp > pings.getLast()) return pings.size();

        int left = 0, right = pings.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (pings.get(mid) >= timestamp) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }
}