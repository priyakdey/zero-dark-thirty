package com.priyakdey.string;

import java.util.*;

public class LongestBalancedSubstring {

    //    Write a function that takes in a string made up of parentheses (( and )). The function
    //    should return an integer representing the length of the longest balanced substring with
    //    regards to parentheses.
    //    A string is said to be balanced if it has as many opening parentheses as it has closing
    //    parentheses and if no parenthesis is unmatched. Note that an opening parenthesis can't
    //    match a closing parenthesis that comes before it, and similarly, a closing parenthesis
    //    can't match an opening parenthesis that comes after it.

    public int longestBalancedSubstring(String string) {
        Objects.requireNonNull(string);
        int length = string.length();
        if (length < 2) return 0;

        Deque<Pair> stack = new ArrayDeque<>(length);
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek().ch == '(') {
                    int startIndex = stack.pop().index;
                    Interval interval = new Interval(startIndex, i);
                    int index = findInsertionIndex(intervals, interval);
                    intervals.add(index, interval);
                }
            } else {
                stack.push(new Pair(ch, i));
            }
        }

        if (intervals.isEmpty()) {
            return 0;
        }

        System.out.println(intervals);
        intervals = merge(intervals);
        System.out.println(intervals);

        int maxLength = 0;
        for (Interval interval : intervals) {
            maxLength = Math.max(maxLength, interval.endIndex - interval.startIndex + 1);
        }

        return maxLength;
    }

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>(intervals.size());
        result.add(intervals.getFirst());


        for (int i = 1; i < intervals.size(); i++) {
            int currStartIndex = intervals.get(i).startIndex;
            int currEndIndex = intervals.get(i).endIndex;

            int prevStartIndex = result.getLast().startIndex;
            int prevEndIndex = result.getLast().endIndex;

            if (currStartIndex > prevEndIndex + 1) {
                result.add(new Interval(currStartIndex, currEndIndex));
            } else {
                result.set(result.size() - 1, new Interval(prevStartIndex, Math.max(prevEndIndex,
                    currEndIndex)));
            }
        }

        return result;
    }

    private int findInsertionIndex(List<Interval> list, Interval interval) {
        if (list.isEmpty() || interval.startIndex < list.getFirst().startIndex) {
            return 0;
        }
        if (interval.startIndex > list.getLast().startIndex) {
            return list.size();
        }

        int index = -1;
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (interval.startIndex > list.get(mid).startIndex()) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }

        return index;
    }

    private record Pair(char ch, int index) {
    }

    private record Interval(int startIndex, int endIndex) {
    }


}
