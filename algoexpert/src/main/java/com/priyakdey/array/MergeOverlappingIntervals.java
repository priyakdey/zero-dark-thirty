package com.priyakdey.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class MergeOverlappingIntervals {

    // Write a function that takes in a non-empty array of arbitrary intervals, merges any
    // overlapping intervals, and returns the new intervals in no particular order.
    // Each interval interval is an array of two integers, with interval[0] as the start of the
    // interval and interval[1] as the end of the interval.
    // Note that back-to-back intervals aren't considered to be overlapping. For example, [1, 5]
    // and [6, 7] aren't overlapping; however, [1, 6] and [6, 7] are indeed overlapping.
    // Also note that the start of any particular interval will always be less than or equal to
    // the end of that interval.

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        Arrays.sort(intervals,
                Comparator.comparing((int[] arr) -> arr[0]).thenComparing((int[] arr) -> arr[1]));

        int length = intervals.length;
        int[][] mergedIntervals = new int[length][2];
        mergedIntervals[0][0] = intervals[0][0];
        mergedIntervals[0][1] = intervals[0][1];
        int cursor = 0;

        for (int i = 1; i < length; i++) {
            int prevStartTime = mergedIntervals[cursor][0];
            int prevEndTime   = mergedIntervals[cursor][1];
            int currStartTime = intervals[i][0];
            int currEndTime   = intervals[i][1];

            int startTime, endTime;

            if (currStartTime <= prevEndTime) {
                startTime = prevStartTime;
                endTime   = Math.max(prevEndTime, currEndTime);
            } else {
                startTime = currStartTime;
                endTime   = currEndTime;
                cursor++;
            }

            mergedIntervals[cursor][0] = startTime;
            mergedIntervals[cursor][1] = endTime;
        }

        return trimToLength(mergedIntervals, cursor + 1);
    }

    private int[][] trimToLength(int[][] array, int length) {
        int[][] trimmed = new int[length][2];
        for (int i = 0; i < length; i++) {
            trimmed[i][0] = array[i][0];
            trimmed[i][1] = array[i][1];
        }

        return trimmed;
    }

}
