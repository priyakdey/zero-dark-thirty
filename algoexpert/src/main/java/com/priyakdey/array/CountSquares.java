package com.priyakdey.array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 27-06-2024
 */
public class CountSquares {

    // Write a function that takes in a list of Cartesian coordinates (i.e., (x, y) coordinates)
    // and returns the number of squares that can be formed by these coordinates.
    // A square must have its four corners amongst the coordinates in order to be counted. A
    // single coordinate can be used as a corner for multiple different squares.
    // You can also assume that no coordinate will be farther than 100 units from the origin


    public int countSquares(int[][] points) {
        Objects.requireNonNull(points);
        int length = points.length;
        if (length == 0) {
            return 0;
        }

        if (points[0].length != 2) {
            throw new IllegalArgumentException("invalid argument");
        }

        if (length < 4) {
            return 0;
        }

        Set<Point> pointsSet = new HashSet<>();
        for (int[] point : points) {
            pointsSet.add(new Point(point[0], point[1]));
        }

        int totalCount = 0;

        for (int i = 0; i < length - 3; i++) {
            Point p1 = new Point(points[i][0], points[i][1]);
            for (int j = i + 1; j < length; j++) {
                Point p2 = new Point(points[j][0], points[j][1]);
                Point midPoint = p1.midPointFrom(p2);
                Vector2 diagonalV = p1.vectorFrom(p2);
                Vector2[] perpendicularVectors = Vector2.perpendicularBisectors(diagonalV);

                for (Vector2 perpendicularVector : perpendicularVectors) {
                    Point p3 = new Point(midPoint.x + perpendicularVector.x / 2,
                            midPoint.y + perpendicularVector.y / 2);
                    Point p4 = new Point(midPoint.x - perpendicularVector.x / 2,
                            midPoint.y - perpendicularVector.y / 2);

                    if (pointsSet.contains(p3) && pointsSet.contains(p4)) {
                        totalCount++;
                    }
                }
            }
        }

        return totalCount / 2;
    }

    private record Point(int x, int y) {

        /**
         * returns the {@link Vector2} representing the line from one point to another.
         * V(p1 -> p2) = (p2.x - p1.x, p2.y - p1.y)
         */
        Vector2 vectorFrom(Point that) {
            return new Vector2(that.x - this.x, that.y - this.y);
        }

        /**
         * midpoint(mx, my) = ((x2 + x1) / 2, (y2 + y1) / 2)
         */
        Point midPointFrom(Point that) {
            return new Point((that.x + this.x) / 2, (that.y + this.y) / 2);
        }

    }

    private record Vector2(int x, int y) {
        /**
         * Perpendicular bisector vector is the line which bisects the line into equal two halves
         * at 90deg.
         * For a vector (x, y) -> perpendicular bisector vector = (-y, x) and (y, -x), one at 90deg,
         * another at -90deg.
         */
        static Vector2[] perpendicularBisectors(Vector2 vector) {
            return new Vector2[]{new Vector2(-vector.y, vector.x),
                    new Vector2(vector.y, -vector.x)};
        }
    }

}
