package com.priyakdey.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 26-06-2024
 */
public class ZigzagTraverse {

    // Write a function that takes in an n x m two-dimensional array (that can be square-shaped
    // when n == m) and returns a one-dimensional array of all the array's elements in zigzag order.
    // Zigzag order starts at the top left corner of the two-dimensional array, goes down by one
    // element, and proceeds in a zigzag pattern all the way to the bottom right corner.
    // Sample Input
    // array = [
    //         [1,  3,  4, 10],
    //         [2,  5,  9, 11],
    //         [6,  8, 12, 15],
    //         [7, 13, 14, 16],
    //         ]
    // Sample Output
    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

    // start with (0, 0) and keep a flag doDown=true, which flips once we go out of bounds.
    // when it goes out of bounds, if going down, change row, col = (prev_row + 1, 0), else
    // change it to (0, prev_col + 1).
    // similarly also need to check bounds at cols - 1 and rows - 1.


    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        Objects.requireNonNull(array);
        int rows = array.size();
        int cols = array.getFirst().size();

        int length = rows * cols;
        List<Integer> flattenList = new ArrayList<>(length);

        int row = 0, col = 0;
        boolean goDown = true;
        int cursor = 0;

        while (cursor < length) {
            flattenList.add(array.get(row).get(col));
            cursor++;

            if (goDown) {
                if (row == rows - 1) {
                    col = col + 1;
                    goDown = false;
                } else if (col == 0) {
                    row = row + 1;
                    goDown = false;
                } else {
                    row = row + 1;
                    col = col - 1;
                }
            } else {
                if (col == cols - 1) {
                    row = row + 1;
                    goDown = true;
                } else if (row == 0) {
                    col = col + 1;
                    goDown = true;
                }  else {
                    row = row - 1;
                    col = col + 1;
                }
            }
        }

        return flattenList;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(List.of(1, 3, 4, 10), List.of(2, 5, 9, 11), List.of(6
                , 8, 12, 15), List.of(7, 13, 14, 16));

        System.out.println(zigzagTraverse(lists));
    }

}
