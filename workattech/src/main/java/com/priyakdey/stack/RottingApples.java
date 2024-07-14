package com.priyakdey.stack;

import java.util.*;

/**
 * @author Priyak Dey
 * @since 15-07-2024
 */
public class RottingApples {

    // You are given an n * m grid where each position can contain one of the three values:
    //
    // Cell Value	Represents
    // 0    Empty Cell
    // 1    Fresh Apple
    // 2    Rotten Apple
    //
    // Every day, all fresh apples which are adjacent to any rotten apple become rotten.
    //
    // Two cells are adjacent if they have a common edge, i.e., each cell can have upto four
    // adjacent cells.
    //
    // Find the minimum number of days required for all the apples to be rotten. If this is not
    // possible return -1.

    int getDaysToRot(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Deque<Tuple> queue = new ArrayDeque<>();

        int fresh = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    Tuple tuple = new Tuple(row, col, 0);
                    queue.offer(tuple);
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int minDays = 0;


        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int row = tuple.row, col = tuple.col, day = tuple.day;
            int _day = day + 1;

            Tuple _tuple = new Tuple(row - 1, col, _day);
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 2;
                queue.offer(_tuple);
                minDays = Math.max(minDays, _day);
                fresh--;
            }

            _tuple = new Tuple(row + 1, col, _day);
            if (row + 1 < rows && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 2;
                queue.offer(_tuple);
                minDays = Math.max(minDays, _day);
                fresh--;
            }

            _tuple = new Tuple(row, col - 1, _day);
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 2;
                queue.offer(_tuple);
                minDays = Math.max(minDays, _day);
                fresh--;
            }

            _tuple = new Tuple(row, col + 1, _day);
            if (col + 1 < cols && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 2;
                queue.offer(_tuple);
                minDays = Math.max(minDays, _day);
                fresh--;
            }
        }

        return fresh == 0 ? minDays : -1;

    }

    private record Tuple(int row, int col, int day) {
    }

}
