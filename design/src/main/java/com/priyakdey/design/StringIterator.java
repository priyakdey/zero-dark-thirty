package com.priyakdey.design;

/**
 * @author Priyak Dey
 */
public class StringIterator {
    // https://leetcode.com/problems/design-compressed-string-iterator/

    private final String s;
    private int index;
    private int nextIndex;
    private int freq;

    public StringIterator(String compressedString) {
        this.s = compressedString;
        this.index = 0;
        int[] arr = extractFreq(1);
        this.freq = arr[0];
        this.nextIndex = arr[1];
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }

        char ch = s.charAt(index);
        this.freq--;
        if (this.freq == 0) {
            this.index = nextIndex;
            if (this.index != s.length()) {
                int[] arr = extractFreq(index + 1);
                this.freq = arr[0];
                this.nextIndex = arr[1];
            }
        }

        return ch;
    }

    public boolean hasNext() {
        return freq > 0 || index < s.length();
    }


    private int[] extractFreq(int start) {
        int curr = start;
        while (curr < s.length() && Character.isDigit(s.charAt(curr))) {
            curr++;
        }

        return new int[]{Integer.parseInt(s.substring(start, curr)), curr};
    }

}
