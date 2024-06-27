package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class MissingNumbers {

    // You're given an unordered list of unique integers nums in the range [1, n], where n
    // represents the length of nums + 2. This means that two numbers in this range are missing
    // from the list.
    // Write a function that takes in this list and returns a new list with the two missing
    // numbers, sorted numerically.

    // Find the expected sum (n + 2)(n + 3) / 2
    // Represent visited numbers by negating the element in that index. For element num, negate
    // nums[num - 1]


    public int[] missingNumbers(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        int expectedTotal = (length + 2) * (length + 3) / 2;
        int total = 0;
        int[] missing = {-1, -1};

        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            total += num;
            int index = num - 1;
            if (index < length) {
                nums[index] *= -1;
            }
        }

        int cursor = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                missing[cursor++] = i + 1;
            }
        }

        if (cursor == 0) {
            missing[0] = length + 1;
            missing[1] = length + 2;
        } else if (cursor == 1) {
            missing[cursor] = expectedTotal - total - missing[0];
        }

        return missing;
    }

}
