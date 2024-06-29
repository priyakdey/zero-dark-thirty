package com.priyakdey.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class Semordnilap {

    // Write a function that takes in a list of unique strings and returns a list of semordnilap
    // pairs.
    // A semordnilap pair is defined as a set of different strings where the reverse of one word
    // is the same as the forward version of the other. For example the words "diaper" and
    // "repaid" are a semordnilap pair, as are the words "palindromes" and "semordnilap".
    // The order of the returned pairs and the order of the strings within each pair does not
    // matter.

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        Objects.requireNonNull(words);
        int length = words.length;
        if (length < 2) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<String>> semordnilap = new ArrayList<>();

        Set<String> seen = new HashSet<>();
        StringBuilder buf = new StringBuilder();

        for (String word : words) {
            buf.append(word);
            buf.reverse();
            if (seen.contains(buf.toString())) {
                ArrayList<String> pair = new ArrayList<>();
                pair.add(word);
                pair.add(buf.toString());
                semordnilap.add(pair);
            }

            buf.setLength(0);
            seen.add(word);
        }

        return semordnilap;
    }

}
