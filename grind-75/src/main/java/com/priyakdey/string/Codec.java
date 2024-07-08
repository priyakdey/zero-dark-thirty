package com.priyakdey.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class Codec {

    // Design an algorithm to encode a list of strings to a string. The encoded string is then
    // sent over the network and is decoded back to the original list of strings.
    //
    // Machine 1 (sender) has the function:
    // string encode(vector<string> strs) {
    //     // ... your code
    //     return encoded_string;
    // }
    //
    // Machine 2 (receiver) has the function:
    // vector<string> decode(string s) {
    //     //... your code
    //     return strs;
    // }
    //
    // So Machine 1 does:
    // string encoded_string = encode(strs);
    // and Machine 2 does:
    // vector<string> strs2 = decode(encoded_string);
    // strs2 in Machine 2 should be the same as strs in Machine 1.
    //
    // Implement the encode and decode methods.
    //
    // You are not allowed to solve the problem using any serialize methods (such as eval).

    /**
     * Encodes a list of strings to a single string.
     *
     * @param strs {@link List<String>} list of strings
     * @return encoded string
     */
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append('-');
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * Decodes a single string to a list of strings.
     *
     * @param s {@link String} input string
     * @return List of decoded strings
     */
    public List<String> decode(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        List<String> strs = new ArrayList<>();

        int length = s.length();
        int i = 0;

        while (i < length) {
            int len = 0;
            char ch;
            while (i < length && (ch = s.charAt(i)) != '-') {
                if (ch < 48 || ch > 57) {
                    throw new IllegalArgumentException("not correctly encoded data. expecting a number");
                }
                len = (len * 10) + (ch - 48);
                i++;
            }

            if (i == length) {
                throw new IllegalArgumentException("not correctly encoded data. reached end of string");
            }

            if (i + len > length) {
                throw new IllegalArgumentException("not correctly encoded data. not data to parse.");
            }

            strs.add(s.substring(i + 1, i + len + 1));

            i = i + len + 1;
        }

        return strs;
    }

}
