package com.priyakdey.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class DailyTemperatures {

    // Given an array of integers temperatures represents the daily temperatures, return an array
    // answer such that answer[i] is the number of days you have to wait after the ith day to get
    // a warmer temperature. If there is no future day for which this is possible, keep answer[i]
    // == 0 instead.


    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = temperatures.length;
        if (length == 1) return new int[]{};

        int[] days = new int[length];
        Deque<Pair> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            Pair pair = new Pair(temperatures[i], i);
            while (!stack.isEmpty() && pair.temp > stack.peek().temp()) {
                Pair _pair = stack.pop();
                days[_pair.day] = i - _pair.day;
            }
            stack.push(pair);
        }

        return days;
    }

    private record Pair(int temp, int day) {
    }

}
