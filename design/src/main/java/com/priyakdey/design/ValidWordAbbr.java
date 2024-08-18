package com.priyakdey.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ValidWordAbbr {
    // https://leetcode.com/problems/unique-word-abbreviation/

    private final Map<String, Set<String>> dictionary;

    public ValidWordAbbr(String[] words) {
        this.dictionary = new HashMap<>();
        for (String word : words) {
            String abbr = abbreviate(word);
            if (!this.dictionary.containsKey(abbr)) {
                this.dictionary.put(abbr, new HashSet<>());
            }
            this.dictionary.get(abbr).add(word);
        }
    }


    public boolean isUnique(String word) {
        String abbr = abbreviate(word);
        return !this.dictionary.containsKey(abbr)
                || (this.dictionary.get(abbr).contains(word)
                && this.dictionary.get(abbr).size() == 1);
    }

    private String abbreviate(String word) {
        if (word.length() < 3) {
            return word;
        }

        return String.valueOf(word.charAt(0)) +
                (word.length() - 2) +
                word.charAt(word.length() - 1);
    }

}
