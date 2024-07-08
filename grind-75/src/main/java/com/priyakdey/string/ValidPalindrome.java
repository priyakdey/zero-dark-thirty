package com.priyakdey.string;

/**
 * @author Priyak Dey
 * @since 03-07-2024
 */
public class ValidPalindrome {

    // A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
    // and removing all non-alphanumeric characters, it reads the same forward and backward.
    // Alphanumeric characters include letters and numbers.
    // Given a string s, return true if it is a palindrome, or false otherwise.

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);

            if (isAlnum(leftCh) && isAlnum(rightCh)) {
                if (!isSame(leftCh, rightCh)) {
                    return false;
                }
                left++;
                right--;
            } else if (isAlnum(leftCh) && !isAlnum(rightCh)) {
                right--;
            } else if (!isAlnum(leftCh) && isAlnum(rightCh)) {
                left++;
            } else if (!isAlnum(leftCh) && !isAlnum(rightCh)) {
                left++;
                right--;
            }
        }

        return true;
    }

    private boolean isSame(int codepoint1, int codepoint2) {
        if (codepoint1 >= 65 && codepoint1 <= 90) {
            codepoint1 = codepoint1 ^ 32;
        }
        if (codepoint2 >= 65 && codepoint2 <= 90) {
            codepoint2 = codepoint2 ^ 32;
        }

        return codepoint1 == codepoint2;
    }

    private boolean isAlnum(int codepoint) {
        return ((codepoint >= 48 && codepoint <= 57) ||
                (codepoint >= 65 && codepoint <= 90) ||
                (codepoint >= 97 && codepoint <= 122));
    }

}
