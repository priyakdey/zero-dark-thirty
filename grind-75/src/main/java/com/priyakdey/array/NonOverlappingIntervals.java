package com.priyakdey.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 * @since 03-07-2024
 */
public class NonOverlappingIntervals {

    // Given an array of intervals intervals where intervals[i] = [starti, endi], return the
    // minimum number of intervals you need to remove to make the rest of the intervals
    // non-overlapping.

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = intervals.length;
        if (length == 1) return 0;

        Arrays.sort(intervals, Comparator.comparing(arr -> arr[1]));

        int removals = 0;

        int prevEnd = intervals[0][1];

        for (int curr = 1; curr < length; curr++) {
            int currStart = intervals[curr][0];
            int currEnd   = intervals[curr][1];

            if (currStart < prevEnd) {
                removals++;
            } else {
                prevEnd = currEnd;
            }

        }

        return removals;
    }

}
