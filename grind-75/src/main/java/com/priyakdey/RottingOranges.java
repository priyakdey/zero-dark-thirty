package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<Cell> queue = new ArrayDeque<>();
        int freshOranges = 0;
        int days = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    freshOranges++;
                } else if (grid[row][col] == 2) {
                    queue.offer(new Cell(row, col, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.row;
            int col = cell.col;
            int day = cell.day;
            days = Math.max(days, day);

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0
                        && nextCol < cols && grid[nextRow][nextCol] == 1) {
                    queue.add(new Cell(nextRow, nextCol, day + 1));
                    freshOranges--;
                    grid[nextRow][nextCol] = 2;
                }
            }
        }

        return freshOranges == 0 ? days : -1;
    }

    private record Cell(int row, int col, int day) {
    }

}
