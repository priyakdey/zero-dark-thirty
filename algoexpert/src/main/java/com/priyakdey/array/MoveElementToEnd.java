package com.priyakdey.array;

import java.util.List;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class MoveElementToEnd {

    // You're given an array of integers and an integer. Write a function that moves all
    // instances of that integer in the array to the end of the array and returns the array.
    // The function should perform this in place (i.e., it should mutate the input array) and
    // doesn't need to maintain the order of the other integers.

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0, right = array.size() - 1;
        while (left < right) {
            if (array.get(left) == toMove && array.get(right) == toMove) {
                right--;
            } else if (array.get(left) == toMove && array.get(right) != toMove) {
                array.set(left, array.get(right));
                array.set(right, toMove);
                left++;
                right--;
            } else if (array.get(left) != toMove && array.get(right) == toMove) {
                left++;
                right--;
            } else if(array.get(left) != toMove && array.get(right) != toMove) {
                left++;
            }
        }
        return array;
    }
}
