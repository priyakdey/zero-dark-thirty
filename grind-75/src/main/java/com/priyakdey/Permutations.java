package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Priyak Dey
 */
public class Permutations {

    // Given an array nums of distinct integers, return all the possible
    // permutations. You can return the answer in any order.

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list =
                Arrays.stream(nums).boxed().collect(Collectors.toList());
        int product = IntStream.rangeClosed(1, nums.length)
                .reduce(1, (acc, element) -> acc * element);
        List<List<Integer>> permutations = new ArrayList<>(product);
        permute(list, 0, permutations);
        return permutations;
    }

    private void permute(List<Integer> nums, int index,
                         List<List<Integer>> permutations) {
        if (index == nums.size()) {
            permutations.add(new ArrayList<>(nums));
            return;
        }
        
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            permute(nums, i + 1, permutations);
            Collections.swap(nums, index, i);
        }

    }

}
