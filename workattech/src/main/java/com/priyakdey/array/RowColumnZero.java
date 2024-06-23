package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class RowColumnZero {

    // Given a matrix, if any of the cells in the matrix is 0, set all the elements in its
    // row and column to 0.

    void setRowColumnZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 1; col < cols; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }

        if (isFirstColZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
