package com.priyakdey.design;

public class RLEIterator {
    // https://leetcode.com/problems/rle-iterator/

    private final int[] encoding;
    private int index;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.index = 0;
    }

    public int next(int n) {
        while (index < encoding.length && n > 0) {
            if (encoding[index] == 0) {
                index += 2;
            } else {
                if (n > encoding[index]) {
                    n -= encoding[index];
                    encoding[index] = 0;
                } else {
                    encoding[index] -= n;
                    n = 0;
                }
            }
        }

        return index != encoding.length ? encoding[index + 1] : -1;
    }
}
