package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class PascalsTriangle {

    // The triangle below is known as Pascal’s triangle.
    // 1
    // 11
    // 121
    // 1331
    // 14641
    //
    // In this triangle, the value at a position is equal to the sum of values of the 2 elements
    // just above it.
    // Examples
    // - The 2nd element of 5th row is 1+3 => 4
    // - The 3rd element of 5th row is 3+3 => 6
    // - The 4th element of 5th row is 3+1 => 4
    //
    // For the leftmost and the rightmost position in each row, the value is 1. The
    // element in the first row is also 1.
    //
    // Given a number n, find the nth row of pascal’s triangle.

    int[] pascalTriangleRow(int rowNo) {
        if (rowNo <= 0) throw new IllegalArgumentException("invalid argument");

        if (rowNo == 1) return new int[]{1};
        if (rowNo == 2) return new int[]{1, 1};

        int length = rowNo + (rowNo + 1);
        int[] buffer = new int[length];
        buffer[0] = 1;
        buffer[1] = 1;

        int prevLeft = 0;
        int prevRight = 1;
        int currLeft = 2;

        for (int row = 3; row <= rowNo; row++) {
            buffer[currLeft] = 1;
            int curr = currLeft + 1;
            for (int i = prevLeft + 1; i <= prevRight; i++) {
                buffer[curr++] = buffer[i] + buffer[i - 1];
            }
            buffer[curr] = 1;
            System.arraycopy(buffer, currLeft, buffer, 0, row);
            prevRight = row - 1;
            currLeft = prevRight + 1;
        }

        int[] pascalRow = new int[rowNo];
        System.arraycopy(buffer, 0, pascalRow, 0, rowNo);
        return pascalRow;
    }

}
