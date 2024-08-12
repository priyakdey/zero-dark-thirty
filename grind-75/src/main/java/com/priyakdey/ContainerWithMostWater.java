package com.priyakdey;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class ContainerWithMostWater {

    // You are given an integer array height of length n. There are n vertical lines drawn such
    // that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    // Find two lines that together with the x-axis form a container, such that the container
    // contains the most water.
    // Return the maximum amount of water a container can store.
    // Notice that you may not slant the container.

    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = heights.length;
        int left = 0, right = length - 1;
        int maxArea = 0;

        while (left < right) {
            int leftBoundHeight  = heights[left];
            int rightBoundHeight = heights[right];
            int area = Math.min(leftBoundHeight, rightBoundHeight) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (leftBoundHeight <= rightBoundHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
