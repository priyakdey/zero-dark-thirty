package com.priyakdey.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 28-06-2024
 */
public class LargestRange {

    // Write a function that takes in an array of integers and returns an array of length 2
    // representing the largest range of integers contained in that array.
    // The first number in the output array should be the first number in the range, while the
    // second number should be the last number in the range.
    // A range of numbers is defined as a set of numbers that come right after each other in the
    // set of real integers. For instance, the output array [2, 6] represents the range {2, 3, 4,
    // 5, 6}, which is a range of length 5. Note that numbers don't need to be sorted or adjacent
    // in the input array in order to form a range.
    // You can assume that there will only be one largest range.

    public static int[] largestRange(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length == 0) return new int[]{0, 0};
        if (length <= 2) return new int[]{array[0], array[length - 1]};

        Set<Integer> visited = HashSet.newHashSet(length);
        Arrays.stream(array).forEach(visited::add);

        int maxRange = 1;
        int left = array[0], right = array[0];

        for (int n : array) {
            if (visited.contains(n)) {
                int x = n;
                while (visited.contains(x)) {
                    visited.remove(x);
                    x++;
                }

                int y = n - 1;
                while (visited.contains(y)) {
                    visited.remove(y);
                    y--;
                }

                int range = (x - 1) - (y + 1) + 1;
                if (range > maxRange) {
                    left = y + 1;
                    right = x - 1;
                    maxRange = range;
                }

            }
        }

        return new int[]{left, right};
    }

}
