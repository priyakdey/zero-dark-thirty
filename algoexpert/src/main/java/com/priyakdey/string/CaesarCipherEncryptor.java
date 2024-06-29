package com.priyakdey.string;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class CaesarCipherEncryptor {

    // Given a non-empty string of lowercase letters and a non-negative integer representing a
    // key, write a function that returns a new string obtained by shifting every letter in the
    // input string by k positions in the alphabet, where k is the key.
    // Note that letters should "wrap" around the alphabet; in other words, the letter z shifted
    // by one returns the letter a.

    public static String caesarCypherEncryptor(String str, int key) {
        if (str == null || key < 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = str.length(); i < length; i++) {
            int ord = str.charAt(i) - 97;     // normalized to 0-25
            ord = ((ord + key) % 26) + 97;
            sb.appendCodePoint(ord);
        }

        return sb.toString();
    }

}
