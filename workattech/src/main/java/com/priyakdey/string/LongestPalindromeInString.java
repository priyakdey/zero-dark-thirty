package com.priyakdey.string;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class LongestPalindromeInString {

    // Given a string s, find the longest palindrome substring in s.
    // If there are multiple valid substrings, find the first one.

    String getLongestPalindrome(String s) {
        Objects.requireNonNull(s);
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        int leftBound = 0, rightBound = 1;
        int maxLength = 1;

        for (int i = 0; i < length; i++) {
            int left, right, subLen;
            left = i - 1;
            right = i + 1;

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            subLen = right - (left + 1);
            if (subLen > maxLength) {
                leftBound = left + 1;
                rightBound = right;
                maxLength = subLen;
            }

            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                left = i - 1;
                right = i + 2;

                while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }

                subLen = right - (left + 1);
                if (subLen > maxLength) {
                    leftBound = left + 1;
                    rightBound = right;
                    maxLength = subLen;
                }
            }
        }

        return s.substring(leftBound, rightBound);
    }

}
