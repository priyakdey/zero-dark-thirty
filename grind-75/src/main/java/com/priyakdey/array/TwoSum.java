package com.priyakdey.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class TwoSum {

    // Given an array of integers nums and an integer target, return indices of the two numbers
    // such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the
    // same element twice.
    // You can return the answer in any order.

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = nums.length;

        Map<Integer, Integer> indexMap = HashMap.newHashMap(length);

        for (int i = 0; i < length; i++) {
            int compliment = target - nums[i];
            if (indexMap.containsKey(compliment)) {
                return new int[]{indexMap.get(compliment), i};
            }
            indexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

}
