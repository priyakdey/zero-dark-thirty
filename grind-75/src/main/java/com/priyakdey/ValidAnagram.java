package com.priyakdey;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 03-07-2024
 */
public class ValidAnagram {

    // Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    // An Anagram is a word or phrase formed by rearranging the letters of a different word or
    // phrase, typically using all the original letters exactly once.

    public boolean isAnagram(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            throw new IllegalArgumentException("invalid arguments");
        }

        if (Objects.equals(s, t)) {
            return true;
        }

        int[] freqArr = new int[26];

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freqArr[ch - 97]++;
        }

        chars = t.toCharArray();
        for (char ch : chars) {
            freqArr[ch - 97]--;
            if (freqArr[ch - 97] < 0) {
                return false;
            }
        }

        return Arrays.stream(freqArr).filter(i -> i == 0).count() == 26;
    }

}
