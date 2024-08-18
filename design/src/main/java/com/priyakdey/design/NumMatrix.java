package com.priyakdey.design;

public class NumMatrix {
    // https://leetcode.com/problems/range-sum-query-2d-immutable/

    private final int[][] currSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        currSum = new int[rows][cols + 1];

        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols + 1; col++) {
                currSum[row][col] =
                        currSum[row][col - 1] + matrix[row][col - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        int colLower = 1 + Math.min(col1, col2);
        int colUpper = 1 + Math.max(col1, col2);

        for (int row = row1; row <= row2; row++) {
            sum += currSum[row][colUpper] - currSum[row][colLower - 1];
        }

        return sum;
    }

}
