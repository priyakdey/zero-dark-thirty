package com.priyakdey.design;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {

    private final Map<Integer, Integer> vec;

    SparseVector(int[] nums) {
        this.vec = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                vec.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct = 0;

        for (Map.Entry<Integer, Integer> entry : vec.vec.entrySet()) {
            int index = entry.getKey();
            int element = entry.getValue();
            if (element != 0 && this.vec.containsKey(index)) {
                dotProduct += element * this.vec.get(index);
            }
        }

        return dotProduct;
    }
}
