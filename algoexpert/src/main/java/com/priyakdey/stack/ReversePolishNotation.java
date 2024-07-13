package com.priyakdey.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class ReversePolishNotation {

    // You're given a list of string tokens representing a mathematical expression using Reverse
    // Polish Notation. Reverse Polish Notation is a notation where operators come after
    // operands, instead of between them. For example 2 4 + would evaluate to 6.
    // Parenthesis are always implicit in Reverse Polish Notation, meaning an expression is
    // evaluated from left to right. All of the operators for this problem take two operands,
    // which will always be the two values immediately preceding the operator. For example, 18 4
    // - 7 / would evaluate to ((18 - 4) / 7) or 2.
    // Write a function that takes this list of tokens and returns the result. Your function
    // should support four operators: +, -, *, and / for addition, subtraction, multiplication,
    // and division respectively.
    // Division should always be treated as integer division, rounding towards zero. For example,
    // 3 / 2 evaluates to 1 and -3 / 2 evaluates to -1. You can assume the input will always be
    // valid Reverse Polish Notation, and it will always result in a valid number. Your code
    // should not edit this input list.

    public int reversePolishNotation(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (Objects.equals(token, "+") || Objects.equals(token, "-") ||
                Objects.equals(token, "*") || Objects.equals(token, "/")) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("invalid expression");
                }
                int b = stack.pop();
                int a = stack.pop();
                int c = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> {
                        if (b == 0) {
                            throw new IllegalArgumentException("cannot divide by zero");
                        }
                        yield a / b;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                };
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }


}
