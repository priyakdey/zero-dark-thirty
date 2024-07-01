package com.priyakdey.array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class ContainsDuplicate {

    // Given an integer array nums, return true if any value appears at least twice in the array,
    // and return false if every element is distinct.

    public boolean containsDuplicate(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        if (length == 1) return false;

        Set<Integer> seen = HashSet.newHashSet(length);

        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }

        return false;
    }

}
