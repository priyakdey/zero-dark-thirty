package com.priyakdey.string;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class FirstNonRepeatingCharacter {

    // Write a function that takes in a string of lowercase English-alphabet letters and returns
    // the index of the string's first non-repeating character.
    // The first non-repeating character is the first character in a string that occurs only once.
    // If the input string doesn't have any non-repeating characters, your function should return
    // -1.

    public int firstNonRepeatingCharacter(String string) {
        Objects.requireNonNull(string);
        int length = string.length();
        if (length == 0) return -1;
        if (length == 1) return 0;
        if (length == 2) return string.charAt(0) != string.charAt(1) ? 0 : -1;

        int[] countArr = new int[26];   // only lowercase english alphabet
        for (char ch : string.toCharArray()) {
            countArr[ch - 97]++;
        }

        int index = -1;

        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);
            if (countArr[ch - 97] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

}
