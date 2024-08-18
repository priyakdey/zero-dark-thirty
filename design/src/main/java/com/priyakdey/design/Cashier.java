package com.priyakdey.design;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
    // https://leetcode.com/problems/apply-discount-every-n-orders/

    private final Map<Integer, Integer> productPrices;
    private final double discountRate;
    private final int discountAt;
    private int customerCount;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.productPrices = HashMap.newHashMap(products.length);
        for (int i = 0; i < products.length; i++) {
            this.productPrices.put(products[i], prices[i]);
        }

        this.discountRate = (100 - discount) / 100.0;
        this.discountAt = n;
        this.customerCount = 1;
    }
    
    public double getBill(int[] product, int[] amount) {
        double totalBill = 0;
        for (int i = 0; i < product.length; i++) {
            totalBill += productPrices.get(product[i]) * amount[i];
        }

        if (customerCount == discountAt) {
            totalBill *= discountRate;
            customerCount = 0;
        }
        customerCount++;
        return totalBill;
    }
}