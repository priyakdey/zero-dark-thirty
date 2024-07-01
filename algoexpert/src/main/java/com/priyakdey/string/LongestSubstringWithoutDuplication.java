package com.priyakdey.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class LongestSubstringWithoutDuplication {

    // Write a function that takes in a string and returns its longest substring without
    // duplicate characters.
    // You can assume that there will only be one longest substring without duplication.

    public static String longestSubstringWithoutDuplication(String str) {
        Objects.requireNonNull(str);

        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLength = 1;
        int left = 0, right = 1;

        int start = 0, curr = 0;
        while (curr < str.length()) {
            char ch = str.charAt(curr);

            if (indexMap.containsKey(ch) && indexMap.get(ch) >= start) {
                int length = curr - start;
                if (length > maxLength) {
                    maxLength = length;
                    left = start;
                    right = curr;
                }
                start = indexMap.get(ch) + 1;
            }

            indexMap.put(ch, curr);
            curr++;
        }

        int length = curr - start;
        if (length > maxLength) {
            left = start;
            right = curr;
        }

        return str.substring(left, right);
    }
}
