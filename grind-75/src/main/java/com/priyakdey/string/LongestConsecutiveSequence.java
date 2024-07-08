package com.priyakdey.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class LongestConsecutiveSequence {

    // Given an unsorted array of integers nums, return the length of the longest consecutive
    // elements sequence.
    // You must write an algorithm that runs in O(n) time.

    public int longestConsecutive(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        if (length <= 1) return length;

        Set<Integer> needToProcess = IntStream.of(nums).boxed().collect(Collectors.toSet());
        int maxRange = 1;

        for (int num : nums) {
            if (needToProcess.contains(num)) {
                needToProcess.remove(num);

                int left = num - 1;
                while (needToProcess.contains(left)) {
                    needToProcess.remove(left);
                    left--;
                }

                int right = num + 1;
                while (needToProcess.contains(right)) {
                    needToProcess.remove(right);
                    right++;
                }

                int range = (right - 1) - (left + 1) + 1;
                maxRange = Math.max(maxRange, range);
            }
        }

        return maxRange;
    }


}
