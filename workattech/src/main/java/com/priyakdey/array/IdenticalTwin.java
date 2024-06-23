package com.priyakdey.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 23-06-2024
 */
public class IdenticalTwin {

    // For an array of integers nums, an identical twin is defined as pair (i, j)
    // where nums[i] is equal to nums[j] and i < j.
    // Given an array nums, find the number of identical twins.

    int getIdenticalTwinsCount(int[] arr) {
        Objects.requireNonNull(arr);
        final Map<Integer, Integer> countMap = new HashMap<>();

        for (int element : arr) {
            countMap.compute(element, (k, v) -> v == null ? 1 : v + 1);
        }

        int twinCount = 0;
        for (int count : countMap.values()) {
            twinCount += (count - 1) * count / 2;
        }

        return twinCount;
    }

}
