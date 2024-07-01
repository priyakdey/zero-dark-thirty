package com.priyakdey.array;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class MajorityElement {

    // Given an array nums of size n, return the majority element.
    // The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
    // that the majority element always exists in the array.

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return nums[0] == nums[1] ? nums[0] : -1;

        int majorityElement = nums[0];
        int weight = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] == majorityElement) {
                weight++;
            } else {
                weight--;
            }

            if (weight == 0) {
                majorityElement = nums[i];
                weight = 1;
            }
        }

        int count = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                count++;
            }
        }

        return count > length / 2 ? majorityElement : -1;
    }

}
