package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 03-07-2024
 */
public class SquaresOfASortedArray {

    // Given an integer array nums sorted in non-decreasing order, return an array of the squares
    // of each number sorted in non-decreasing order.

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }
        int length = nums.length;
        int[] products = new int[length];
        int left = 0, right = length - 1;
        int curr = length - 1;

        while (curr >= 0) {
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if (a >= b) {
                products[curr] = a;
                left++;
            } else {
                products[curr] = b;
                right--;
            }
            curr--;
        }

        return products;
    }

}
