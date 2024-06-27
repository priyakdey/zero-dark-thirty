package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class SortedSquareArray {

    // Write a function that takes in a non-empty array of integers that are sorted in ascending
    // order and returns a new array of the same length with the squares of the original integers also
    // sorted in ascending order.

    public int[] sortedSquaredArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("invalid arguments");
        }

        int length = array.length;
        int left = 0, right = length - 1;
        int[] squareArray = new int[length];
        int curr = length -1;

        while (left <= right) {
            int a = array[left] * array[left];
            int b = array[right] * array[right];

            if (a >= b) {
                squareArray[curr--] = a;
                left++;
            } else {
                squareArray[curr--] = b;
                right--;
            }
        }

        return squareArray;
    }

}
