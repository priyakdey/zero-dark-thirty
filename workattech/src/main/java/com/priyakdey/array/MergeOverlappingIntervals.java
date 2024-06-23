package com.priyakdey.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class MergeOverlappingIntervals {

    // Given a list of intervals, merge them to get a list of non-overlapping intervals.
    // interval_i = [start_i, end_i]
    //
    // Example:
    // Intervals: [[1, 2], [2, 3], [1, 4], [5, 6]]
    //
    //         [1, 2] and [2, 3] can be merged to form [1, 3].
    // Now, [1, 3] and [1, 4] can be merged to form [1, 4].
    //         [1, 4] and [5, 6] have no intersection.
    // Hence above intervals are merged to form:
    //         [[1, 4], [5, 6]]
    //
    // Note that the final list should be in ascending order.

    int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            throw new IllegalArgumentException("input array cannot be null or empty");
        if (intervals.length == 1) return intervals;

        // sort the array acc to start time. If start time is same, sort by end time
        intervals = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt((int[] arr) -> arr[0])
                        .thenComparingInt((int[] arr) -> arr[1]))
                .toArray(int[][]::new);

        int length = intervals.length;

        int[][] mergedIntervals = new int[length][2];
        mergedIntervals[0] = intervals[0];
        int cursor = 0;

        for (int i = 1; i < length; i++) {
            int prevStart = mergedIntervals[cursor][0];
            int prevEnd = mergedIntervals[cursor][1];

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int start, end;     // represents the [start, end] interval which needs to be merged or appended

            if (currStart == prevStart || currStart <= prevEnd) {
                start = prevStart;
                end = Math.max(prevEnd, currEnd);
            } else {
                start = currStart;
                end = currEnd;
                cursor++;
            }

            mergedIntervals[cursor] = new int[]{start, end};
        }

        return trimToSize(mergedIntervals, cursor + 1);
    }


    private static int[][] trimToSize(int[][] arr, int length) {
        int[][] arr2 = new int[length][2];
        for (int i = 0; i < length; i++) {
            int[] copy = new int[2];
            // deep clones to avoid any shocking changes from outside
            System.arraycopy(arr[i], 0, copy, 0, 2);
            arr2[i] = copy;
        }

        return arr2;
    }

}
