package com.priyakdey;

/**
 * @author Priyak Dey
 * @since 10-07-2024
 */
public class TrappingRainWater {

    // Given n non-negative integers representing an elevation map where the width of each bar is
    // 1, compute how much water it can trap after raining.

    public int trap(int[] heights) {
        if (heights == null || heights.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = heights.length;
        int width = 1;

        if (length < 3)  return 0;
        if (length == 3) {
            if (heights[1] >= heights[0] || heights[1] >= heights[2]) {
                return 0;
            } else {
                return (Math.min(heights[0], heights[2]) - heights[1]) * width;
            }
        }

        int[] leftBound = new int[length];
        int maxHeight = heights[0];
        for (int i = 1; i < length - 1; i++) {
            maxHeight = Math.max(maxHeight, heights[i]);
            leftBound[i] = maxHeight;
        }

        int[] rightBound = new int[length];
        maxHeight = heights[length -1];
        for (int i = length - 2; i >= 1; i--) {
            maxHeight = Math.max(maxHeight, heights[i]);
            rightBound[i] = maxHeight;
        }

        int totalVolume = 0;
        for (int i = 1; i < length - 1; i++) {
            int volume = (Math.min(leftBound[i], rightBound[i]) - heights[i]) * width;
            totalVolume += volume;
        }

        return totalVolume;
    }
}
