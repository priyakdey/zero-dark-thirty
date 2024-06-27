package com.priyakdey.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 26-06-2024
 */
public class LongestSubarrayWithSum {

    // Write a function that takes in a non-empty array of non-negative integers and a
    // non-negative integer representing a target sum. The function should find the longest
    // subarray where the values collectively sum up to equal the target sum. Return an array
    // containing the starting index and ending index of this subarray, both inclusive.
    // If there is no subarray that sums up to the target sum, the function should return an
    // empty array. You can assume that the given inputs will only ever have one answer.

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length == 0) return new int[]{};
        if (length == 1) return array[0] == targetSum ? new int[]{0, 0} : new int[]{};

        int left = -1, right = -1;
        int maxSubarrLength = 0;
        int currSum = 0;
        Map<Integer, Integer> prefixSumMap = HashMap.newHashMap(length + 1);
        prefixSumMap.put(0, -1);

        for (int i = 0; i < length; i++) {
            currSum += array[i];
            int compliment = currSum - targetSum;
            if (prefixSumMap.containsKey(compliment)) {
                int index = prefixSumMap.get(compliment);
                int subarrLength = i - (index + 1) + 1;
                if (subarrLength > maxSubarrLength) {
                    maxSubarrLength = subarrLength;
                    left = index + 1;
                    right = i;
                }
            }
            if (array[i] == targetSum && 1 > maxSubarrLength) {
                maxSubarrLength = 1;
                left = i;
                right = i;
            }

            if (array[i] != 0) {
                prefixSumMap.put(currSum, i);
            }
        }

        return maxSubarrLength != 0 ? new int[]{left, right} : new int[]{};
    }

}
