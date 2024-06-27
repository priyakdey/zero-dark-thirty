package com.priyakdey.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 27-06-2024
 */
public class NonConstructibleChange {

    // Given an array of positive integers representing the values of coins in your possession,
    // write a function that returns the minimum amount of change (the minimum sum of money) that
    // you cannot create. The given coins can have any positive integer value and aren't
    // necessarily unique (i.e., you can have multiple coins of the same value).
    // For example, if you're given coins = [1, 2, 5], the minimum amount of change that you
    // can't create is 4. If you're given no coins, the minimum amount of change that you can't
    // create is 1.

    // Idea is, sort the coins and iterate over keeping a track of current sum.
    // If coins[i] > curr_sum + 1, then we cannot create curr_sum + 1
    // else keep iterating.

    public int nonConstructibleChange(int[] coins) {
        Objects.requireNonNull(coins);
        int length = coins.length;
        if (length == 0) return 1;
        if (length == 1) return coins[0] == 1 ? 2 : 1;

        Arrays.sort(coins);

        int currChange = 0;

        for (int i = 0; i < length; i++) {
            if (coins[i] > currChange + 1) {
                return currChange + 1;
            }
            currChange += coins[i];
        }

        return currChange + 1;
    }

}
