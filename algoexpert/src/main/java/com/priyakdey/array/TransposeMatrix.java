package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class TransposeMatrix {
    // You're given a 2D array of integers matrix. Write a function that returns the transpose of the matrix.
    // The transpose of a matrix is a flipped version of the original matrix across its main
    // diagonal (which runs from top-left to bottom-right); it switches the row and column
    // indices of the original matrix.
    // You can assume the input matrix always has at least 1 value; however its width and height
    // are not necessarily the same.

    public int[][] transposeMatrix(int[][] matrix) {
        Objects.requireNonNull(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposedMatrix = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transposedMatrix[col][row] = matrix[row][col];
            }
        }

        return transposedMatrix;
    }
}
