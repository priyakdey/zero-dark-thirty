package com.priyakdey;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class MoveZeroes {

    // Given an integer array nums, move all 0's to the end of it while maintaining the relative
    // order of the non-zero elements.
    // Note that you must do this in-place without making a copy of the array.

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = nums.length;
        int swapAt = 0, curr = 0;

        while (curr < length) {
            if (nums[curr] != 0) {
                nums[swapAt] = nums[curr];
                swapAt++;
            }
            curr++;
        }

        while (swapAt < length) {
            nums[swapAt++] = 0;
        }
    }

}
