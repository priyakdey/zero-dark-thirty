package com.priyakdey.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class ContiguousArray {

    // Given a binary array nums, return the maximum length of a contiguous subarray with an
    // equal number of 0 and 1.

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int weight = 0;
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            weight += num == 1 ? 1 : -1;
            if (weight == 0) {
                maxLength = Math.max(maxLength, i - 0 + 1);
            } else {
                if (map.containsKey(weight)) {
                    maxLength = Math.max(maxLength, i - (map.get(weight) + 1) + 1);
                } else {
                    map.put(weight, i);
                }
            }
        }

        return maxLength;
    }

}
