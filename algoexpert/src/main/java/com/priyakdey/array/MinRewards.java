package com.priyakdey.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 25-06-2024
 */
public class MinRewards {

    // Imagine that you're a teacher who's just graded the final exam in a class. You have a list
    // of student scores on the final exam in a particular order (not necessarily sorted), and
    // you want to reward your students. You decide to do so fairly by giving them arbitrary
    // rewards following two rules:
    // All students must receive at least one reward.
    // Any given student must receive strictly more rewards than an adjacent student (a student
    // immediately to the left or to the right) with a lower score and must receive strictly
    // fewer rewards than an adjacent student with a higher score.
    // Write a function that takes in a list of scores and returns the minimum number of rewards
    // that you must give out to students to satisfy the two rules.
    // You can assume that all students have different scores; in other words, the scores are all
    // unique.

    // Finding the local min/max is the trick.
    // At any given point, the reward[i] = max(reward[i], reward[i + 1] + 1)
    // Lets give 1 reward each to all students to start with.
    // Iterate from [1..len(arr)), and if score[i] > score[i - 1], reward[i] = max(reward[i],
    // reward[i - 1] + 1) - since this is first iteration, we can simplify to reward[i] =
    // rewards[i - 1] + 1.
    // Iterate from [len(arr) - 2..0], and if score[i] > score[i + 1], reward[i] = max(reward[i],
    // reward[i + 1] + 1)

    public static int minRewards(int[] scores) {
        Objects.requireNonNull(scores);
        int length = scores.length;
        if (length == 1) {
            return 1;
        }

        // give 1 reward to each student
        int[] rewards = new int[length];
        Arrays.fill(rewards, 1);

        // iterate left to right
        for (int i = 1; i < length; i++) {
            if (scores[i] > scores[i - 1]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        // iterate from right to left
        for (int i = length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }

        int totalRewards = 0;
        for (int i = 0; i < length; i++) {
            totalRewards += rewards[i];
        }

        return totalRewards;
    }

}
