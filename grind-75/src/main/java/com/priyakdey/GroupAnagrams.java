package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class GroupAnagrams {

    // Given an array of strings strs, group the anagrams together. You can return the answer in
    // any order.
    // An Anagram is a word or phrase formed by rearranging the letters of a different word or
    // phrase, typically using all the original letters exactly once.

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    private static final int MOD = 1000000007;
    private static final int SEED = 5381;

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        Map<Integer, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int hash = hash(str);
            if (!anagrams.containsKey(hash)) {
                anagrams.put(hash, new ArrayList<>());
            }
            anagrams.get(hash).add(str);
        }

        return anagrams.values().stream().toList();
    }

    private int hash(String str) {
        long hash = SEED;

        for(char ch : str.toCharArray()) {
            hash = (hash * PRIMES[ch - 97]) % MOD;
        }

        return Math.toIntExact(hash);
    }


}
