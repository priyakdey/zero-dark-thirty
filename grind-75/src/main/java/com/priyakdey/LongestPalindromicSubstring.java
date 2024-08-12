package com.priyakdey;

/**
 * @author Priyak Dey
 * @since 07-07-2024
 */
public class LongestPalindromicSubstring {

    // Given a string s, return the longest palindromic substring in s.

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid arguments");
        }

        int length = s.length();
        if (length == 1) return s;
        if (length == 2) return s.charAt(0) == s.charAt(1) ? s : Character.toString(s.charAt(0));

        int substrMaxLen = 1;
        int left = 0, right = 1;    // [left, right)

        for (int i = 0; i < length; i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            int substrLen = r - (l + 1);
            if (substrLen > substrMaxLen) {
                substrMaxLen = substrLen;
                left = l + 1;
                right = r;
            }

            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                substrLen = r - (l + 1);
                if (substrLen > substrMaxLen) {
                    substrMaxLen = substrLen;
                    left = l + 1;
                    right = r;
                }
            }
        }

        return s.substring(left, right);
    }

}
