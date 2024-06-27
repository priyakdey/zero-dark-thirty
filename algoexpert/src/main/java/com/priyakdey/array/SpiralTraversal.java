package com.priyakdey.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 27-06-2024
 */
public class SpiralTraversal {

    // Write a function that takes in an n x m two-dimensional array (that can be square-shaped
    // when n == m) and returns a one-dimensional array of all the array's elements in spiral order.
    // Spiral order starts at the top left corner of the two-dimensional array, goes to the
    // right, and proceeds in a spiral pattern all the way until every element has been visited.

    public static List<Integer> spiralTraverse(int[][] array) {
        Objects.requireNonNull(array);
        int rows = array.length;
        if (rows == 0) return Collections.emptyList();
        Objects.requireNonNull(array[0]);
        int cols = array[0].length;
        if (cols == 0) return Collections.emptyList();

        int rowIter = Math.ceilDiv(rows, 2);
        int colIter = Math.ceilDiv(cols, 2);

        int row, col;
        List<Integer> flattenMatrix = new ArrayList<>(rows * cols);

        for (int i = 0; i < rowIter && i < colIter; i++) {
            // top row
            row = i;
            for (col = i; col < cols - i; col++) {
                flattenMatrix.add(array[row][col]);
            }

            // right col
            col = cols - 1 - i;
            for (row = i + 1; row < rows - i; row++) {
                flattenMatrix.add(array[row][col]);
            }

            // bottom row
            if (rows - 1 - i > i) {
                row = rows - 1 - i;
                for (col = cols - 1 - i - 1; col >= i; col--) {
                    flattenMatrix.add(array[row][col]);
                }
            }

            // left col
            if (cols - 1 - i > i) {
                col = i;
                for (row = rows - 1 - i - 1; row >= i + 1; row--) {
                    flattenMatrix.add(array[row][col]);
                }
            }
        }

        return flattenMatrix;
    }

}
