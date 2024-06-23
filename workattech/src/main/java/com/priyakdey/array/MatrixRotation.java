package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class MatrixRotation {

    // Given a matrix, rotate the matrix 90 degrees clockwise.

    int[][] rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int[][] rotatedMatrix = transpose(matrix);

        int rows = rotatedMatrix.length;
        int cols = rotatedMatrix[0].length;

        for (int row = 0; row < rows; row++) {
            int left = 0, right = cols - 1;
            while (left < right) {
                swap(rotatedMatrix, row, left, row, right);
                left++;
                right--;
            }
        }

        return rotatedMatrix;
    }

    private int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] tMatrix = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                tMatrix[col][row] = matrix[row][col];
            }
        }

        return tMatrix;
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

}
