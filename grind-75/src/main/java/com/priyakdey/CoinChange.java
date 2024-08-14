package com.priyakdey;


import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class CoinChange {

    // You are given an integer array coins representing coins of different
    // denominations and an integer amount representing a total amount of money.
    //
    // Return the fewest number of coins that you need to make up that amount.
    // If that amount of money cannot be made up by any combination of the
    // coins, return -1.
    //
    // You may assume that you have an infinite number of each kind of coin.

    public int coinChange(int[] coins, int amount) {
        int[][] cache = new int[coins.length + 1][amount + 1];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        int count = coinChange(coins, 0, amount, cache);
        return count != Integer.MAX_VALUE ? count : -1;
    }

    private int coinChange(int[] coins, int index, int amount, int[][] cache) {
        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (cache[index][amount] != -1) {
            return cache[index][amount];
        }

        int count = coinChange(coins, index + 1, amount, cache);

        for (int i = index; i < coins.length; i++) {
            int _count = coinChange(coins, i, amount - coins[i], cache);
            if (_count != Integer.MAX_VALUE) {
                count = Math.min(count, 1 + _count);
            }
        }

        cache[index][amount] = count;
        return count;
    }
}
