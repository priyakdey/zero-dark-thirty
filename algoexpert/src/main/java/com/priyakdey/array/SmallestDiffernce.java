package com.priyakdey.array;

import java.util.Arrays;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class SmallestDiffernce {

    // Write a function that takes in two non-empty arrays of integers, finds the pair of numbers
    // (one from each array) whose absolute difference is closest to zero, and returns an array
    // containing these two numbers, with the number from the first array in the first position.
    // Note that the absolute difference of two integers is the distance between them on the real
    // number line. For example, the absolute difference of -5 and 5 is 10, and the absolute
    // difference of -5 and -4 is 1.
    // You can assume that there will only be one pair of numbers with the smallest difference.

    // Sort the array, and move two pointer from the start of each array. Move the pointer to the
    // to the right for smaller element, since this makes us try and go closer to the element
    // from the second array. If one goes out of range, we can clearly say, last diff was the one
    // that min, since right of other array is always gonna produce bigger distances.


    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne == null || arrayOne.length == 0 || arrayTwo == null || arrayTwo.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int length1 = arrayOne.length;
        int length2 = arrayTwo.length;

        int minDiff = Math.abs(arrayOne[0] - arrayTwo[length2 - 1]);
        int[] result = {arrayOne[0], arrayTwo[length2 - 1]};
        int i = 0, j = 0;

        while (i < length1 && j < length2) {
            int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = arrayOne[i];
                result[1] = arrayTwo[j];
            }
            if (diff == 0) {
                break;
            }

            if (arrayOne[i] < arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
