package com.priyakdey.design;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    // https://leetcode.com/problems/my-calendar-i/

    private final List<BookingTime> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if (calendar.isEmpty()) {
            calendar.add(new BookingTime(start, end));
            return true;
        }

        int index = findIndex(start, end);
        if (index == -1) {
            return false;
        }

        calendar.add(index, new BookingTime(start, end));
        return true;
    }

    private int findIndex(int start, int end) {
        if (end <= calendar.getFirst().start) {
            return 0;
        } else if (start >= calendar.getLast().end) {
            return calendar.size();
        }

        int left = 0, right = calendar.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (end <= calendar.get(mid).start) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    private record BookingTime(int start, int end) {
    }
}