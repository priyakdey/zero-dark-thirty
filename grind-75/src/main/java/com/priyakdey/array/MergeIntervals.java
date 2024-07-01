package com.priyakdey.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class MergeIntervals {

    // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
    // intervals, and return an array of the non-overlapping intervals that cover all the
    // intervals in the input.

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0])
                                         .thenComparing(interval -> interval[1]));

        int[][] mergedIntervals = new int[length][2];
        int cursor = 0;
        mergedIntervals[0] = intervals[0];

        for (int i = 1; i < length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int prevStart = mergedIntervals[cursor][0];
            int prevEnd = mergedIntervals[cursor][1];

            int start, end;

            if (currStart == prevStart) {
                start = currStart;
                end = Math.max(currEnd, prevEnd);
            } else {
                if (currStart <= prevEnd) {
                    // merge
                    start = prevStart;
                    end = Math.max(currEnd, prevEnd);
                } else {
                    start = currStart;
                    end = currEnd;
                    // append
                    cursor++;
                }
            }

            mergedIntervals[cursor] = new int[]{start, end};
        }

        mergedIntervals = trimArray(mergedIntervals, cursor - 0 + 1);

        return mergedIntervals;
    }

    private int[][] trimArray(int[][] arr, int length) {
        int n = arr[0].length;
        int[][] trimmedArray = new int[length][n];

        for (int i = 0; i < length; i++) {
            int[] copy = new int[n];
            System.arraycopy(arr[i], 0, copy, 0, n);
            trimmedArray[i] = copy;
        }

        return trimmedArray;
    }

}
