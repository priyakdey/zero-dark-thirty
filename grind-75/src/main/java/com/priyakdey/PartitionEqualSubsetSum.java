package com.priyakdey;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class PartitionEqualSubsetSum {

    // Given an integer array nums, return true if you can partition the
    // array into two subsets such that the sum of the elements in both
    // subsets is equal or false otherwise.

    public boolean canPartition(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        if (length < 2) return false;
        if (length == 2) return nums[0] == nums[1];

        int sum = Arrays.stream(nums).sum();
        return canPartition(nums, 0, 0, sum);
    }

    private boolean canPartition(int[] nums, int index, int leftSum,
                                 int rightSum) {
        if (leftSum == rightSum) return true;
        if (index == nums.length) return false;

        return canPartition(nums, index + 1, leftSum + nums[index],
                rightSum - nums[index]);
    }

}
