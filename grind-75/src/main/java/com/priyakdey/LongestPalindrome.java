package com.priyakdey;

/**
 * @author Priyak Dey
 * @since 03-07-2024
 */
public class LongestPalindrome {

    // Given a string s which consists of lowercase or uppercase letters, return the length of
    // the longest palindrome that can be built with those letters.
    // Letters are case sensitive, for example, "Aa" is not considered a palindrome.

    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        int length = s.length();
        if (length == 1) return 1;
        if (length == 2) return s.charAt(0) == s.charAt(1) ? 2 : 1;

        // 0-25  = 65-90    offset: 65
        // 26-51 = 97-122   offset: 71
        int[] freqArr = new int[26 + 26];

        for (char ch : s.toCharArray()) {
            if (ch >= 65 && ch <= 90) {
                freqArr[ch - 65]++;
            } else {
                freqArr[ch - 71]++;
            }
        }

        int maxLength = 0;
        boolean oddLength = false;
        for (int freq : freqArr) {
            if ((freq & 1) == 0) {
                maxLength += freq;
            } else {
                maxLength += freq - 1;
                oddLength = true;
            }

        }

        return maxLength + (oddLength ? 1 : 0);
    }

}
