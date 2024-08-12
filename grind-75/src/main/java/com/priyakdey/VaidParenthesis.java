package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class VaidParenthesis {

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine
    // if the input string is valid.
    // An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.
    // 3. Every close bracket has a corresponding open bracket of the same type.

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !Objects.equals(stack.pop(), map.get(ch))) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
