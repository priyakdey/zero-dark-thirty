package com.priyakdey;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 3) return n;

        int prev = 1, curr = 2;
        for (int i = 3; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }

        return curr;
    }

}
