package com.priyakdey;

public class MaximumSubarray {

    // https://leetcode.com/problems/maximum-subarray/description/

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxTill = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxTill = Math.max(maxTill + nums[i], nums[i]);
            max = Math.max(max, maxTill);
        }

        return max;
    }

}
