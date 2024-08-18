package com.priyakdey.design;

public class NumArray {
    // https://leetcode.com/problems/range-sum-query-mutable/

    private final int[] nums;
    private final int[] currSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.currSum = new int[nums.length + 1];

        for (int i = 1; i < nums.length + 1; i++) {
            currSum[i] = currSum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i < currSum.length; i++) {
            currSum[i] = currSum[i] + diff;
        }
    }

    public int sumRange(int left, int right) {
        return currSum[right + 1] - currSum[left];
    }
}
