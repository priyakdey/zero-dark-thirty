package com.priyakdey;

import java.util.*;

public class ZeroOneMatrix {

    // https://leetcode.com/problems/01-matrix/description/

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Deque<Tuple> queue = new ArrayDeque<>();
        Set<Tuple> visited = new HashSet<>();

        int[][] distances = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                distances[row][col] = Integer.MAX_VALUE;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    Tuple tuple = new Tuple(row, col, 0);
                    queue.offer(tuple);
                    visited.add(tuple);
                }
            }
        }

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            int row = tuple.row;
            int col = tuple.col;
            int distance = tuple.distance;
            distances[row][col] = Math.min(distances[row][col], distance);


            Tuple tuple1 = new Tuple(row + 1, col, distance + 1);
            if (row + 1 < rows && !visited.contains(tuple1)) {
                queue.offer(tuple1);
                visited.add(tuple1);
            }

            Tuple tuple2 = new Tuple(row - 1, col, distance + 1);
            if (row - 1 >= 0 && !visited.contains(tuple2)) {
                queue.offer(tuple2);
                visited.add(tuple2);
            }

            Tuple tuple3 = new Tuple(row, col + 1, distance + 1);
            if (col + 1 < cols && !visited.contains(tuple3)) {
                queue.offer(tuple3);
                visited.add(tuple3);
            }

            Tuple tuple4 = new Tuple(row, col - 1, distance + 1);
            if (col - 1 >= 0 && !visited.contains(tuple4)) {
                queue.offer(tuple4);
                visited.add(tuple4);
            }
        }

        return distances;
    }

    private record Tuple(int row, int col, int distance) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return row == tuple.row && col == tuple.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

}
