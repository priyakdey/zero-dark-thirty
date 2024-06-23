package com.priyakdey.array;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class MaxConsecutiveOnes {

    // Given an array A, find the maximum number of consecutive 1s in the array.

    int getMaxConsecutiveOnes(int[] A) {
        Objects.requireNonNull(A);

        int maxStreak = 0;
        int currStreak = 0;

        for (int element : A) {
            if (element == 1) {
                currStreak++;
            } else {
                maxStreak = Math.max(maxStreak, currStreak);
                currStreak = 0;
            }
        }

        maxStreak = Math.max(maxStreak, currStreak);
        return maxStreak;
    }

}
