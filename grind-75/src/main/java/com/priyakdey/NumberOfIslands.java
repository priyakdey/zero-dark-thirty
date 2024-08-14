package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author Priyak Dey
 */
public class NumberOfIslands {

    // Given an m x n 2D binary grid grid which represents a map of '1's
    // (land) and '0's (water), return the number of islands.
    //
    // An island is surrounded by water and is formed by connecting adjacent
    // lands horizontally or vertically. You may assume all four edges of the
    // grid are all surrounded by water.

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<Cell> queue = new ArrayDeque<>();
        int islandCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    queue.offer(new Cell(row, col));
                    grid[row][col] = '0';

                    while (!queue.isEmpty()) {
                        Cell cell = queue.poll();
                        for (int[] direction : directions) {
                            int nextRow = cell.row + direction[0];
                            int nextCol = cell.col + direction[1];
                            if (nextRow >= 0 && nextRow < rows && nextCol >= 0
                                    && nextCol < cols && grid[nextRow][nextCol] == '1') {
                                queue.offer(new Cell(nextRow, nextCol));
                                grid[nextRow][nextCol] = '0';
                            }
                        }

                    }

                }
            }
        }

        return islandCount;
    }

    private record Cell(int row, int col) {
    }

}
