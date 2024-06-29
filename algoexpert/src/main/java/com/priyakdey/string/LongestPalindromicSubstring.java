package com.priyakdey.string;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class LongestPalindromicSubstring {

    // Write a function that, given a string, returns its longest palindromic substring.
    // A palindrome is defined as a string that's written the same forward and backward. Note
    // that single-character strings are palindromes.
    // You can assume that there will only be one longest palindromic substring.

    public static String longestPalindromicSubstring(String str) {
        Objects.requireNonNull(str);
        int length = str.length();
        if (length <= 1) return str;

        int subarrMaxLen = 1;
        int left = 0, right = 1;        // left inclusive, right exclusive

        int l, r, subarrLen;

        for (int i = 0; i < length; i++) {
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < length && str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }

            subarrLen = (r - 1) - (l + 1) + 1;
            if (subarrLen > subarrMaxLen) {
                left = l + 1;
                right = r;
                subarrMaxLen = subarrLen;
            }

            if (i < length - 1 && str.charAt(i) == str.charAt(i + 1)) {
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < length && str.charAt(l) == str.charAt(r)) {
                    l--;
                    r++;
                }

                subarrLen = (r - 1) - (l + 1) + 1;
                if (subarrLen > subarrMaxLen) {
                    left = l + 1;
                    right = r;
                    subarrMaxLen = subarrLen;
                }
            }
        }

        return str.substring(left, right);
    }

}
