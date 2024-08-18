package com.priyakdey.design;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    // https://leetcode.com/problems/product-of-the-last-k-numbers/

    private final List<Integer> elements;

    public ProductOfNumbers() {
        elements = new ArrayList<>();
    }
    
    public void add(int num) {
        elements.add(num);
    }
    
    public int getProduct(int k) {
        int product = 1;
        int curr = elements.size() - 1;
        while (k > 0) {
            product *= elements.get(curr--);
            k--;
        }

        return product;
    }
}
