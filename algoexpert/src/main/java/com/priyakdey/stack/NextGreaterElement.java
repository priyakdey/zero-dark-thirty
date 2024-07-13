package com.priyakdey.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class NextGreaterElement {

    // Write a function that takes in an array of integers and returns a new array containing, at
    // each index, the next element in the input array that's greater than the element at that
    // index in the input array.
    //
    // In other words, your function should return a new array where outputArray[i] is the next
    // element in the input array that's greater than inputArray[i]. If there's no such next
    // greater element for a particular index, the value at that index in the output array should
    // be -1. For example, given array = [1, 2], your function should return [2, -1].
    //
    // Additionally, your function should treat the input array as a circular array. A circular
    // array wraps around itself as if it were connected end-to-end. So the next index after the
    // last index in a circular array is the first index. This means that, for our problem, given
    // array = [0, 0, 5, 0, 0, 3, 0, 0], the next greater element after 3 is 5, since the array
    // is circular.

    public int[] nextGreaterElement(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;

        if (length == 0) return new int[]{};
        if (length == 1) return new int[]{-1};

        int[] nextGreaterElement = new int[length];
        Arrays.fill(nextGreaterElement, -1);

        Deque<Pair> stack = new ArrayDeque<>(length);

        for (int j = 1; j <= 2; j++) {
            for (int i = 0; i < length; i++) {
                int num = array[i];
                while (!stack.isEmpty() && num > stack.peek().num) {
                    nextGreaterElement[stack.pop().index] = num;
                }
                stack.push(new Pair(num, i));
            }
        }

        return nextGreaterElement;

    }

    private record Pair(int num, int index) {
    }
}
