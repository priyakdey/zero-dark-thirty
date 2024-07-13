package com.priyakdey.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class LargestPark {

    // A city wants to build a new public park, and you've been tasked with finding the largest
    // park they can build without disturbing existing infrastructure.
    //
    // Write a function that takes in a two-dimensional array (a matrix) land representing the
    // total land of the city from a top-down view. Each value in land is a boolean; false values
    // are pieces of land not currently in use, while true values are pieces of land currently in
    // use by other infrastructure. Return the area of the largest possible park.
    //
    // The largest possible park will be placed exclusively on unused land (false values).
    // Moreover, the city wants the park to be a perfect rectangle. If there is no available
    // land, your function should return 0.

    public int largestPark(boolean[][] land) {
        if (land == null || land.length == 0 || land[0] == null || land[0].length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int[][] histogram = toHistogram(land);

        int rows = histogram.length;
        int cols = histogram[0].length;

        int maxArea = 0;

        Deque<Pair> stack = new ArrayDeque<>(cols);

        for (int row = 0; row < rows; row++) {
            int area = findMaxArea(histogram, row, cols, 1, stack);
            stack.clear();
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int findMaxArea(int[][] histogram, int row, int cols, int landWidth,
                            Deque<Pair> stack) {
        int[] rightBound = new int[cols];
        Arrays.fill(rightBound, cols - 1);
        for (int col = 0; col < cols; col++) {
            int height = histogram[row][col];
            while (!stack.isEmpty() && height < stack.peek().height) {
                rightBound[stack.pop().index] = col - 1;
            }
            stack.push(new Pair(height, col));
        }

        stack.clear();

        int[] leftBound = new int[cols];
        for (int col = cols - 1; col >= 0; col--) {
            int height = histogram[row][col];
            while (!stack.isEmpty() && height < stack.peek().height) {
                leftBound[stack.pop().index] = col + 1;
            }
            stack.push(new Pair(height, col));
        }

        int maxArea = 0;
        for (int col = 0; col < cols; col++) {
            int breadth = (rightBound[col] - leftBound[col] + 1) * landWidth;
            int height = histogram[row][col];
            int area = height * breadth;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    /**
     * Returns the max height at a particular position, going upwards.
     *
     * @param land int[][] matrix of land
     * @return heights at each position in the form of a histogram
     */
    private int[][] toHistogram(boolean[][] land) {
        int rows = land.length;
        int cols = land[0].length;

        int[][] heights = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0) {
                    heights[row][col] = land[row][col] ? 0 : 1;
                } else {
                    heights[row][col] = land[row][col] ? 0 : 1 + heights[row - 1][col];
                }
            }
        }

        return heights;
    }

    private record Pair(int height, int index) {
    }

}
