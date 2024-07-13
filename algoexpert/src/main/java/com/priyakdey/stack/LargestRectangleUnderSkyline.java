package com.priyakdey.stack;

import java.util.*;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class LargestRectangleUnderSkyline {

    // Write a function that takes in an array of positive integers representing the heights of
    // adjacent buildings and returns the area of the largest rectangle that can be created by
    // any number of adjacent buildings, including just one building. Note that all buildings
    // have the same width of 1 unit.
    // For example, given buildings = [2, 1, 2], the area of the largest rectangle that can be
    // created is 3, using all three buildings. Since the minimum height of the three buildings
    // is 1, you can create a rectangle that has a height of 1 and a width of 3 (the number of
    // buildings). You could also create rectangles of area 2 by using only the first building or
    // the last building, but these clearly wouldn't be the largest rectangles. Similarly, you
    // could create rectangles of area 2 by using the first and second building or the second and
    // third building.
    // To clarify, the width of a created rectangle is the number of buildings used to create the
    // rectangle, and its height is the height of the smallest building used to create it.
    // Note that if no rectangles can be created, your function should return 0.

    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        Objects.requireNonNull(buildings);
        int width = 1;
        int length = buildings.size();
        if (length == 0) return 0;
        if (length == 1) return buildings.getFirst() * width;

        Deque<Pair> stack = new ArrayDeque<>(length);

        int[] rightBound = new int[length];
        Arrays.fill(rightBound, length - 1);
        for (int i = 0; i < length; i++) {
            int height = buildings.get(i);
            while (!stack.isEmpty() && height < stack.peek().height) {
                rightBound[stack.pop().index] = i - 1;
            }
            stack.push(new Pair(height, i));
        }

        stack.clear();

        int[] leftBound = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int height = buildings.get(i);
            while (!stack.isEmpty() && height < stack.peek().height) {
                leftBound[stack.pop().index] = i + 1;
            }
            stack.push(new Pair(height, i));
        }


        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            int height = buildings.get(i);
            int breadth = (rightBound[i] - leftBound[i] + 1) * width;
            int area = height * breadth;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private record Pair(int height, int index) {
    }

}
