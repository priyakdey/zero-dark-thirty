package com.priyakdey.array;

import java.util.Arrays;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class ArrayOfProducts {

    // Write a function that takes in a non-empty array of integers and returns an array of the
    // same length, where each element in the output array is equal to the product of every other
    // number in the input array.
    // In other words, the value at output[i] is equal to the product of every number in the
    // input array other than input[i].
    // Note that you're expected to solve this problem without using division.

    public int[] arrayOfProducts(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = array.length;
        int[] products = new int[length];
        Arrays.fill(products, 1);

        int prefixProduct = 1;
        int suffixProduct = 1;

        int left = 1, right = length - 2;

        for (int i = 1; i < length; i++) {
            prefixProduct *= array[left - 1];
            products[left] *= prefixProduct;
            left++;

            suffixProduct *= array[right + 1];
            products[right] *= suffixProduct;
            right--;
        }

        return products;
    }

}
