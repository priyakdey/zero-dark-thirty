package com.priyakdey.string;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class OneEdit {

    // You're given two strings stringOne and stringTwo. Write a function that determines if
    // these two strings can be made equal using only one edit.
    // There are 3 possible edits:
    //     Replace: One character in one string is swapped for a different character.
    //     Add: One character is added at any index in one string.
    //     Remove: One character is removed at any index in one string.
    // Note that both strings will contain at least one character. If the strings are the same,
    // your function should return true.

    public boolean oneEdit(String stringOne, String stringTwo) {
        Objects.requireNonNull(stringOne);
        Objects.requireNonNull(stringTwo);

        if (Objects.equals(stringOne, stringTwo)) {
            return true;
        }

        int levDist = levenshteinDist(stringOne, stringTwo);
        return levDist == 1;
    }

    private int levenshteinDist(String stringOne, String stringTwo) {
        int length1 = stringOne.length();
        int length2 = stringTwo.length();

        int[][] table = new int[length1 + 1][length2 + 1];

        for (int i = 0; i < length2; i++) {
            table[length1][i] = length2 - i;
        }

        for (int i = 0; i < length1; i++) {
            table[i][length2] = length1 - i;
        }

        for (int index1 = length1 - 1; index1 >= 0; index1--) {
            for (int index2 = length2 - 1; index2 >= 0; index2--) {
                if (stringOne.charAt(index1) == stringTwo.charAt(index2)) {
                    table[index1][index2] = table[index1 + 1][index2 + 1];
                } else {
                    table[index1][index2] = 1 + min(table[index1][index2 + 1],
                            table[index1 + 1][index2], table[index1 + 1][index2 + 1]);
                }
            }
        }

        return table[0][0];
    }

    private int levenshteinDist(String stringOne, int index1, String stringTwo, int index2,
                                int[][] cache) {
        if (index1 == stringOne.length()) {
            return stringTwo.length() - index2;
        }

        if (index2 == stringTwo.length()) {
            return stringOne.length() - index1;
        }

        if (cache[index1][index2] != 0) {
            return cache[index1][index2];
        }

        if (stringOne.charAt(index1) == stringTwo.charAt(index2)) {
            int dist = levenshteinDist(stringOne, index1 + 1, stringTwo, index2 + 1, cache);
            cache[index1][index2] = dist;
            return dist;
        }

        int dist = 1 + min(
                levenshteinDist(stringOne, index1, stringTwo, index2 + 1, cache),
                levenshteinDist(stringOne, index1 + 1, stringTwo, index2, cache),
                levenshteinDist(stringOne, index1 + 1, stringTwo, index2 + 1, cache)
        );
        cache[index1][index2] = dist;
        return dist;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
