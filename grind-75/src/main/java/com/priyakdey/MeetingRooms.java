package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class MeetingRooms {

    // Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if
    // a person could attend all meetings.

    public boolean canAttendMeetings(int[][] intervals) {
        Objects.requireNonNull(intervals);
        int length = intervals.length;
        if (length < 2) return true;

        Arrays.sort(intervals,
                Comparator.comparing((int[] arr) -> arr[0]).thenComparing((int[] arr) -> arr[1]));

        for (int i = 1; i < length; i++) {
            int prevEndTime = intervals[i - 1][1];
            int currStartTime = intervals[i][0];
            if (currStartTime < prevEndTime) {
                return false;
            }
        }

        return true;
    }

}
