package com.priyakdey.array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class ZeroSumSubarray {

    // You're given a list of integers nums. Write a function that returns a boolean representing
    // whether there exists a zero-sum subarray of nums.
    // A zero-sum subarray is any subarray where all of the values add up to zero. A subarray is
    // any contiguous section of the array. For the purposes of this problem, a subarray can be
    // as small as one element and as long as the original array.

    public boolean zeroSumSubarray(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        if (length == 0) return false;
        if (length == 1) return nums[0] == 0;
        if (length == 2) return nums[0] == 0 || nums[1] == 0 || nums[0] + nums[1] == 0;

        Set<Integer> visited = new HashSet<>();
        int prefixSum = 0;
        for (int element : nums) {
            prefixSum += element;
            if (element == 0 || prefixSum == 0 || visited.contains(prefixSum)) {
                return true;
            }
            visited.add(prefixSum);
        }

        return false;
    }
}
