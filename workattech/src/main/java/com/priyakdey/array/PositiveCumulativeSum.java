package com.priyakdey.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 23-06-2024
 */
public class PositiveCumulativeSum {

    // The cumulative sum of an array at index i is defined as the sum of all elements of the
    // array from index 0 to index i. The positive cumulative sum of an array is a list of only
    // those cumulative sums which are positive.

    List<Integer> getPositiveCumulativeSum(int[] arr) {
        Objects.requireNonNull(arr);
        if (arr.length == 0) {
            return new ArrayList<>(0);
        }

        List<Integer> cumulativeSumList = new ArrayList<>();

        int cumulativeSum = 0;
        for (int element : arr) {
            cumulativeSum += element;
            if (cumulativeSum > 0) {
                cumulativeSumList.add(cumulativeSum);

            }
        }

        return cumulativeSumList;
    }

}
