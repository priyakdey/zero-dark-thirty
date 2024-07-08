package com.priyakdey.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // Given a string s, find the length of the longest substring without repeating characters.

    public int lengthOfLongestSubstring(String s) {
        Objects.requireNonNull(s);
        int length = s.length();
        if (length <= 1) return length;

        Map<Character, Integer> indexMap = new HashMap<>();

        int maxLength = 1;
        int start = 0;

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            if (indexMap.containsKey(ch) && indexMap.get(ch) >= start) {
                maxLength = Math.max(maxLength, i - start);
                start = indexMap.get(ch) + 1;
            }

            indexMap.put(ch, i);
        }

        maxLength = Math.max(maxLength, length - start);
        return maxLength;
    }

}
