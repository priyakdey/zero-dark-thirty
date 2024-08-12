package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class LongestValidParentheses {

    // Given a string containing just the characters '(' and ')', return the length of the
    // longest valid (well-formed) parentheses substring.

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }

    public int longestValidParentheses(String s) {
        Objects.requireNonNull(s);
        int sLength = s.length();
        if (sLength < 2) return 0;

        int length = 0;
        int maxLength = 0;

        Deque<Character> stack = new ArrayDeque<>(sLength);




        return dp(s);
    }

    private int dp(String s) {
        // calculate the longest length of a valid substring ending at ith position
        int length = s.length();
        int[] dp = new int[length + 1];

        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == ')' && i > 0 && dp[i] == 0) {
                dp[i + 1] = 2 + dp[i - 1];
                maxLength = Math.max(maxLength, dp[i + 1]);
            }
        }

        return maxLength;
    }
}
