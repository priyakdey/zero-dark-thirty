package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class RotateArray {

    // Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = nums.length;
        k = k % length;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    /**
     * Reverses an array in the range [start, end].
     * @param nums int[]
     * @param start int
     * @param end int
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
