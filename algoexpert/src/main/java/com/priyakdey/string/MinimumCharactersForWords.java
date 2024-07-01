package com.priyakdey.string;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class MinimumCharactersForWords {

    // Write a function that takes in an array of words and returns the smallest array of
    // characters needed to form all of the words. The characters don't need to be in any
    // particular order.
    // For example, the characters ["y", "r", "o", "u"] are needed to form the words ["your",
    // "you", "or", "yo"].
    // Note: the input words won't contain any spaces; however, they might contain punctuation
    // and/or special characters.

    public char[] minimumCharactersForWords(String[] words) {
        Objects.requireNonNull(words);
        int length = words.length;
        if (length == 0) return new char[]{};

        int[] countArr = new int[256];

        for (String word : words) {
            int[] wordCountArr = new int[256];
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                wordCountArr[ch]++;
            }

            for (int i = 0; i < 256; i++) {
                if (wordCountArr[i] != 0) {
                    countArr[i] = Math.max(countArr[i], wordCountArr[i]);
                }
            }
        }

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            if (countArr[i] > 0) {
                buf.repeat(i, countArr[i]);
            }
        }

        return buf.toString().toCharArray();
    }

}
