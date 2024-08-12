package com.priyakdey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class EmployeeFreeTime {

    // We are given a list schedule of employees, which represents the working time for each
    // employee.
    // Each employee has a list of non-overlapping Intervals, and these intervals are in sorted
    // order.
    // Return the list of finite intervals representing common, positive-length free time for all
    // employees, also in sorted order.(Even though we are representing Intervals in the form [x,
    // y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0]
    // .start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we
    // wouldn't include intervals like [5, 5] in our answer, as they have zero length.


    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.isEmpty()) {
            throw new IllegalArgumentException("invalid arguments");
        }
        List<Interval> intervals = flattenAndSort(schedule);
        intervals = merge(intervals);

        List<Interval> breaks = new ArrayList<>();

        for (int i = 1, length = intervals.size(); i < length; i++) {
            int prevEnd = intervals.get(i - 1).end;
            int currStart = intervals.get(i).start;
            if (prevEnd != currStart) {
                breaks.add(new Interval(prevEnd, currStart));
            }
        }

        return breaks;
    }

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<>(intervals.size());

        merged.add(intervals.getFirst());

        for (int i = 1, length = intervals.size(); i < length; i++) {
            int prevStart = merged.getLast().start;
            int prevEnd = merged.getLast().end;

            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;

            if (currStart == prevStart || currStart <= prevEnd) {
                merged.getLast().start = prevStart;
                merged.getLast().end = Math.max(currEnd, prevEnd);
            } else {
                merged.add(new Interval(currStart, currEnd));
            }
        }

        return merged;
    }

    private List<Interval> flattenAndSort(List<List<Interval>> schedule) {
        return schedule
                .stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing((Interval interval) -> interval.start)
                                  .thenComparing((Interval interval) -> interval.end))
                .toList();
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }


}
