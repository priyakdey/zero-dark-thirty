package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class BackspaceStringCompare {

    // Given two strings s and t, return true if they are equal when both are typed into empty
    // text editors. '#' means a backspace character.
    // Note that after backspacing an empty text, the text will continue empty.

    public boolean backspaceCompare(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        Deque<Character> sChars = normalizeString(s);
        Deque<Character> tChars = normalizeString(t);

        while (!sChars.isEmpty() && !tChars.isEmpty()) {
            if (!Objects.equals(sChars.pop(), tChars.pop())) {
                return false;
            }
        }

        return sChars.isEmpty() && tChars.isEmpty();
    }

    private Deque<Character> normalizeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        return stack;
    }



}
