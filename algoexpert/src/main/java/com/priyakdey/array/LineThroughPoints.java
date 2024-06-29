package com.priyakdey.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class LineThroughPoints {

    // You're given an array of points plotted on a 2D graph (the xy-plane). Write a function
    // that returns the maximum number of points that a single line (or potentially multiple
    // lines) on the graph passes through.
    // The input array will contain points represented by an array of two integers [x, y]. The
    // input array will never contain duplicate points and will always contain at least one point.

    public int lineThroughPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = points.length;
        if (length <= 2) {
            return length;
        }

        Set<Line> lines = new HashSet<>();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                float slope = calcSlope(x1, y1, x2, y2);
                float c = calcConstant(x1, y1, slope);
                lines.add(new Line(slope, c));
            }
        }

        int maxCount = 0;

        for (Line line : lines) {
            int count = 0;
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                float slope = line.slope;
                float c = line.c;
                if (slope == Float.POSITIVE_INFINITY || slope == Float.NEGATIVE_INFINITY) {
                    if (x == c) {
                        count++;
                    }
                } else if (y == slope * x + c) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    private float calcConstant(int x, int y, float slope) {
        if (slope == Float.POSITIVE_INFINITY || slope == Float.NEGATIVE_INFINITY) {
            return x;
        }

        return y - (x * slope);
    }

    private float calcSlope(int x1, int y1, int x2, int y2) {
        int dy = y2 - y1;
        int dx = x2 - x1;
        if (dx == 0) return y2 > y1 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        return ((float) dy) / dx;
    }

    private record Line(float slope, float c) {
    }

}
