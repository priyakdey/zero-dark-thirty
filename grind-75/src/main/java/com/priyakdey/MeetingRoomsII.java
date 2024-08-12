package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class MeetingRoomsII {

    // Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
    // return the minimum number of conference rooms required.

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length != 2) {
            throw new IllegalArgumentException("invalid argument");
        }

        int[] startTimes = Arrays.stream(intervals).mapToInt(arr -> arr[0]).sorted().toArray();
        int[] endTimes   = Arrays.stream(intervals).mapToInt(arr -> arr[1]).sorted().toArray();

        int i = 1, j = 0;
        int length = startTimes.length;
        int rooms = 1;
        int emptyRooms = 0;

        while (i < length && j < length) {
            if (startTimes[i] < endTimes[j]) {
                if (emptyRooms == 0) {
                    rooms++;
                } else {
                    emptyRooms--;
                }
                i++;
            } else {
                emptyRooms++;
                j++;
            }
        }

        return rooms;
    }

}
