package com.priyakdey.string;

import java.util.*;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class GroupAnagrams {

    // Write a function that takes in an array of strings and groups anagrams together.
    // Anagrams are strings made up of exactly the same letters, where order doesn't matter. For
    // example, "cinema" and "iceman" are anagrams; similarly, "foo" and "ofo" are anagrams.
    // Your function should return a list of anagram groups in no particular order.

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    private static final int SEED = 5381;
    private static final int MOD = 1_000_000_007;

    public static List<List<String>> groupAnagrams(List<String> words) {
        Objects.requireNonNull(words);
        int length = words.size();
        if (length == 0) return List.of();
        if (length == 1) return List.of(List.of(words.getFirst()));

        Map<Integer, List<String>> groupMap = new HashMap<>();

        for (String word : words) {
            int hash = calcHash(word);
            if (!groupMap.containsKey(hash)) {
                groupMap.put(hash, new ArrayList<>());
            }

            groupMap.get(hash).add(word);
        }

        return groupMap.values().stream().toList();
    }

    private static int calcHash(String word) {
        long hash = SEED;

        for (char ch : word.toCharArray()) {
            hash = (hash * PRIMES[ch - 97]) % MOD;
        }

        return (int) hash;
    }

}
