package com.priyakdey.stacks;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class DecodeString {

    // Given an encoded string, return its decoded string.
    // The encoding rule is: k[encoded_string], where the encoded_string inside the square
    // brackets is being repeated exactly k times. Note that k is guaranteed to be a positive
    // integer.
    // You may assume that the input string is always valid; there are no extra white spaces,
    // square brackets are well-formed, etc. Furthermore, you may assume that the original data
    // does not contain any digits and that digits are only for those repeat numbers, k. For
    // example, there will not be input like 3a or 2[4].
    // The test cases are generated so that the length of the output will never exceed 10^5.

    public String decodeString(String s) {
        if (s == null || s.length() < 4) {
            throw new IllegalArgumentException("invalid argument");
        }

        return decodeString(s, 0);
    }

    private String decodeString(String s, int index) {
        int repeat = 0;

        return "";

    }

}
