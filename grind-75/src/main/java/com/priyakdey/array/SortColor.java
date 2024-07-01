package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class SortColor {

    // Given an array nums with n objects colored red, white, or blue, sort them in-place so that
    // objects of the same color are adjacent, with the colors in the order red, white, and blue.
    // We will use the integers 0, 1, and 2 to represent the color red, white, and blue,
    // respectively.
    // You must solve this problem without using the library's sort function.

    // Dutch sort algorithm

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int left = 0, curr = 0, right = nums.length - 1;

        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                curr++;
                left++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                swap(nums, curr, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
