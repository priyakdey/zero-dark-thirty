package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class ProductOfArrayExceptSelf {

    // Given an integer array nums, return an array answer such that answer[i] is equal to the
    // product of all the elements of nums except nums[i].
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    // You must write an algorithm that runs in O(n) time and without using the division operation.

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) throw new IllegalArgumentException("invalid input");

        int length = nums.length;
        int[] productArray = new int[length];
        Arrays.fill(productArray, 1);

        int prefixProduct = 1, suffixProduct = 1;

        int left = 1, right = length - 2;

        while (left < length) {
            prefixProduct = prefixProduct * nums[left - 1];
            productArray[left] = productArray[left] * prefixProduct;
            left++;

            suffixProduct = suffixProduct * nums[right + 1];
            productArray[right] = productArray[right] * suffixProduct;
            right--;
        }

        return productArray;
    }

}
