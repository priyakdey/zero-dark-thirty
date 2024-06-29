package com.priyakdey.string;

import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class PalindromeCheck {

    // Write a function that takes in a non-empty string and that returns a boolean representing
    // whether the string is a palindrome.
    // A palindrome is defined as a string that's written the same forward and backward. Note
    // that single-character strings are palindromes.


    public static boolean isPalindrome(String str) {
        Objects.requireNonNull(str);
        int length = str.length();
        if (length <= 1) return true;

        int left = 0, right = length - 1;
        while (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;
    }

}
