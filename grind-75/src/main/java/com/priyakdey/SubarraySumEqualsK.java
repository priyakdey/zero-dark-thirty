package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class SubarraySumEqualsK {

    // Given an array of integers nums and an integer k, return the total number of subarrays
    // whose sum equals to k.
    // A subarray is a contiguous non-empty sequence of elements within an array.

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        Map<Integer, Integer> sumFreqMap = new HashMap<>();
        int currSum = 0;
        int count = 0;

        for (int num : nums) {
            currSum += num;
            if (currSum == k) {
                count++;
            }

            int compliment = currSum - k;
            if (sumFreqMap.containsKey(compliment)) {
                count += sumFreqMap.get(compliment);
            }

            sumFreqMap.compute(currSum, (_k, v) -> v == null ? 1 : v + 1);
        }

        return count;
    }

}
