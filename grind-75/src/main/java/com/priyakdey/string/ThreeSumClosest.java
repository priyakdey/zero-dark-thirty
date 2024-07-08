package com.priyakdey.string;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class ThreeSumClosest {

    // Given an integer array nums of length n and an integer target, find three integers in nums
    // such that the sum is closest to target.
    // Return the sum of the three integers.
    // You may assume that each input would have exactly one solution.

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("invalid arguments");
        }

        if (nums.length == 3) {
            return IntStream.of(nums).sum();
        }

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int sum = minDiff + target;     // okay to over/underflow, we will re-assign this at
        // least once

        for (int i = 0, length = nums.length; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = length - 1;

            while (left < right) {
                int _sum = nums[i] + nums[left] + nums[right];
                int diff = target - _sum;
                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    sum = _sum;
                }

                if (diff == 0) {
                    break;
                } else if (diff < 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return sum;
    }


}
