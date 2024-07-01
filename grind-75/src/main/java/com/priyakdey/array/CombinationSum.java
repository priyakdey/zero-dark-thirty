package com.priyakdey.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 * @since 02-07-2024
 */
public class CombinationSum {

    // Given an array of distinct integers candidates and a target integer target, return a list
    // of all unique combinations of candidates where the chosen numbers sum to target. You may
    // return the combinations in any order.
    // The same number may be chosen from candidates an unlimited number of times. Two
    // combinations are unique if the frequency of at least one of the chosen numbers is different.
    // The test cases are generated such that the number of unique combinations that sum up to
    // target is less than 150 combinations for the given input.

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            throw new IllegalArgumentException("invalid argument");
        }

        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(candidates, 0, target, new ArrayList<>(), combinations);
        return combinations;
    }

    private void combinationSum(int[] candidates, int index, int target,
                                List<Integer> combination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0) {
            return;     // all elements are positive acc to constraints
        }

        if (index >= candidates.length) {
            return;
        }

        // do not take element at index into account
        combinationSum(candidates, index + 1, target, combination, combinations);

        // consider the current element
        combination.add(candidates[index]);
        combinationSum(candidates, index, target - candidates[index], combination, combinations);
        combination.removeLast();

    }
}
