package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class MajorityElement {

    // Write a function that takes in a non-empty, unordered array of positive integers and
    // returns the array's majority element without sorting the array and without using more than
    // constant space.
    // An array's majority element is an element of the array that appears in over half of its
    // indices. Note that the most common element of an array (the element that appears the most
    // times in the array) isn't necessarily the array's majority element; for example, the
    // arrays [3, 2, 2, 1] and [3, 4, 2, 2, 1] both have 2 as their most common element, yet
    // neither of these arrays have a majority element, because neither 2 nor any other element
    // appears in over half of the respective arrays' indices.
    // You can assume that the input array will always have a majority element.

    public int majorityElement(int[] array) {
        Objects.requireNonNull(array);
        int majorityElement = array[0];
        int bias = 1;

        for (int i = 1, length = array.length; i < length; i++) {
            if (array[i] != majorityElement) {
                bias -= 1;
            } else {
                bias += 1;
            }

            if (bias == 0) {
                majorityElement = array[i];
                bias = 1;
            }
        }

        int count = 0;
        for (int num : array) {
            if (num == majorityElement) {
                count++;
            }
        }

        return count > array.length / 2 ? majorityElement : -1;
    }


}
