package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class LargestRectangleInHistogram {

    // Given an array of integers heights representing the histogram's bar height where the width
    // of each bar is 1, return the area of the largest rectangle in the histogram.

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            throw new IllegalArgumentException("invalid arguments");
        }

        int length = heights.length;
        Deque<Pair> stack = new ArrayDeque<>();

        int[] rightBound = new int[heights.length];
        Arrays.fill(rightBound, length - 1);

        for (int i = 0; i < length; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && height < stack.peek().height) {
                Pair pair = stack.pop();
                rightBound[pair.index] = i - 1;
            }

            stack.push(new Pair(height, i));
        }

        stack.clear();

        int[] leftBound = new int[heights.length];

        for (int i = length - 1; i >= 0; i--) {
            int height = heights[i];
            while (!stack.isEmpty() && height < stack.peek().height) {
                Pair pair = stack.pop();
                leftBound[pair.index] = i + 1;
            }

            stack.push(new Pair(height, i));
        }

        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            int breadth = (rightBound[i] - leftBound[i] + 1) * 1;
            int height = heights[i];
            int area = height * breadth;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private record Pair(int height, int index) {
    }

}
