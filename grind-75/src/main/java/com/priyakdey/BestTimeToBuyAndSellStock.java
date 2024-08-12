package com.priyakdey;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class BestTimeToBuyAndSellStock {

    // You are given an array prices where prices[i] is the price of a given stock on the ith day.
    // You want to maximize your profit by choosing a single day to buy one stock and choosing a
    // different day in the future to sell that stock.
    // Return the maximum profit you can achieve from this transaction. If you cannot achieve any
    // profit, return 0.

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("invalid arguments");
        }

        int length = prices.length;
        if (length == 1) return 0;

        int buyingPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < length; i++) {
            if (prices[i] < buyingPrice) {
                buyingPrice = prices[i];
            } else {
                int profit = prices[i] - buyingPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
