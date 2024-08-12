package com.priyakdey;

import java.util.Objects;

public class BinarySearch {

    // https://leetcode.com/problems/binary-search/description/

    public int search(int[] nums, int target) {
        Objects.requireNonNull(nums);

        int length = nums.length;
        int left = 0, right = length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

}
