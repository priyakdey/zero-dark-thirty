package com.priyakdey.design;

public class NeighborSum {
    // https://leetcode.com/problems/design-neighbor-sum-service/

    private static final int[][] ADJACENT_DIRECTION
            = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int[][] DIAGONAL_DIRECTION
            = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    private final int[][] grid;
    private final int rows;
    private final int cols;


    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public int adjacentSum(int value) {
        return findSum(value, ADJACENT_DIRECTION);
    }

    public int diagonalSum(int value) {
        return findSum(value, DIAGONAL_DIRECTION);
    }

    private int findSum(int value, int[][] directions) {
        int sum = 0;
        int[] cell = indexOf(value);
        int row = cell[0], col = cell[1];

        for (int[] direction : directions) {
            int dr = direction[0];
            int dc = direction[1];
            int nextRow = row + dr, nextCol = col + dc;
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                continue;
            }
            sum += grid[nextRow][nextCol];
        }

        return sum;
    }

    private int[] indexOf(int value) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == value) {
                    return new int[]{row, col};
                }
            }
        }

        throw new IllegalArgumentException(value + " is not present in grid");
    }
}