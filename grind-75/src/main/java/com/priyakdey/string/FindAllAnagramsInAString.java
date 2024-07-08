package com.priyakdey.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class FindAllAnagramsInAString {

    // Given two strings s and p, return an array of all the start indices of p's anagrams in s.
    // You may return the answer in any order.
    // An Anagram is a word or phrase formed by rearranging the letters of a different word or
    // phrase, typically using all the original letters exactly once.

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        int pLength = p.length();
        int sLength = s.length();

        if (Objects.equals(s, p)) return List.of(0);
        if (sLength < pLength) return List.of();

        int[] pCharFreq = new int[26];
        int[] sCharFreq = new int[26];

        for (int i = 0; i < pLength; i++) {
            pCharFreq[p.charAt(i) - 97]++;
            sCharFreq[s.charAt(i) - 97]++;
        }

        List<Integer> indices = new ArrayList<>(sLength);

        if (isAnagram(sCharFreq, pCharFreq)) {
            indices.add(0);
        }

        for (int i = 1; i < sLength - pLength + 1; i++) {
            sCharFreq[s.charAt(i - 1) - 97]--;
            sCharFreq[s.charAt(i + pLength - 1) - 97]++;

            if (isAnagram(pCharFreq, sCharFreq)) {
                indices.add(i);
            }

        }

        return indices;
    }

    private boolean isAnagram(int[] arr1, int[] arr2) {
        for (int i = 0, length = arr1.length; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

}
