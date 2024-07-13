package com.priyakdey.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class BalancedBrackets {

    // Write a function that takes in a string made up of brackets ((, [, {, ), ], and }) and
    // other optional characters. The function should return a boolean representing whether the
    // string is balanced with regards to brackets.
    //
    // A string is said to be balanced if it has as many opening brackets of a certain type as it
    // has closing brackets of that type and if no bracket is unmatched. Note that an opening
    // bracket can't match a corresponding closing bracket that comes before it, and similarly, a
    // closing bracket can't match a corresponding opening bracket that comes after it. Also,
    // brackets can't overlap each other as in [(]).

    public static boolean balancedBrackets(String str) {
        Objects.requireNonNull(str);
        if (str.isEmpty()) return true;
        int length = str.length();

        Deque<Character> stack = new ArrayDeque<>(length);

        for (char ch : str.toCharArray()) {
            switch (ch) {
                case 40, 91, 123:
                    stack.push(ch);
                    break;
                case 41:
                    if (stack.isEmpty() || !Objects.equals(stack.pop(), '(')) {
                        return false;
                    }
                    break;
                case 93:
                    if (stack.isEmpty() || !Objects.equals(stack.pop(), '[')) {
                        return false;
                    }
                    break;
                case 125:
                    if (stack.isEmpty() || !Objects.equals(stack.pop(), '{')) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        return stack.isEmpty();
    }

}
