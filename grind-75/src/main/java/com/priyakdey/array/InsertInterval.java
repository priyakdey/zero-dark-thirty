package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class InsertInterval {

    // You are given an array of non-overlapping intervals intervals where intervals[i] =
    // [starti, endi] represent the start and the end of the ith interval and intervals is sorted
    // in ascending order by starti. You are also given an interval newInterval = [start, end]
    // that represents the start and end of another interval.Insert newInterval into intervals
    // such that intervals is still sorted in ascending order by starti and intervals still does
    // not have any overlapping intervals (merge overlapping intervals if necessary).
    // Return intervals after the insertion.
    // Note that you don't need to modify intervals in-place. You can make a new array and return i

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Objects.requireNonNull(intervals);
        Objects.requireNonNull(newInterval);

        if (newInterval.length != 2) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = intervals.length;
        if (length == 0) {
            return new int[][]{newInterval};
        }

        int index = findInsertionIndex(intervals, newInterval);

        int[][] newIntervals = new int[length + 1][2];
        if (index == 0) {
            newIntervals[0] = newInterval;
            System.arraycopy(intervals, 0, newIntervals, 1, length);
        } else if (index == length) {
            System.arraycopy(intervals, 0, newIntervals, 0, length);
            newIntervals[length] = newInterval;
        } else {
            System.arraycopy(intervals, 0, newIntervals, 0, (index - 1) - (0) + 1);
            newIntervals[index] = newInterval;
            System.arraycopy(intervals, index, newIntervals, index + 1,
                    newIntervals.length - 1 - (index + 1) + 1);
        }

        // shadow length to point to length of new array
        length = newIntervals.length;

        int[][] mergedIntervals = new int[length][2];
        mergedIntervals[0] = newIntervals[0];

        int cursor = 0;

        for (int i = 1; i < length; i++) {
            int start, end;

            int prevStart = mergedIntervals[cursor][0];
            int prevEnd = mergedIntervals[cursor][1];

            int currStart = newIntervals[i][0];
            int currEnd = newIntervals[i][1];

            if (currStart == prevStart || currStart <= prevEnd) {
                start = prevStart;
                end = Math.max(prevEnd, currEnd);
            } else {
                start = currStart;
                end = currEnd;
                cursor++;
            }

            mergedIntervals[cursor][0] = start;
            mergedIntervals[cursor][1] = end;
        }

        return trimToSize(mergedIntervals, cursor + 1);

    }


    private int findInsertionIndex(int[][] intervals, int[] newInterval) {
        int length = intervals.length;

        if (newInterval[0] <= intervals[0][0]) return 0;
        if (newInterval[0] >= intervals[length - 1][0]) return length;

        int left = 0, right = length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (newInterval[0] == intervals[mid][0]) {
                if (newInterval[1] <= intervals[mid][1]) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (newInterval[0] < intervals[mid][0]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    private int[][] trimToSize(int[][] array, int length) {
        int[][] copy = new int[length][2];

        for (int i = 0; i < length; i++) {
            System.arraycopy(array[i], 0, copy[i], 0, 2);
        }

        return copy;
    }

}
