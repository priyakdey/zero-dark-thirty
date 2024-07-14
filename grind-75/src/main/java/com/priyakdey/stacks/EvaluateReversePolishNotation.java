package com.priyakdey.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class EvaluateReversePolishNotation {

    // You are given an array of strings tokens that represents an arithmetic expression in a
    // Reverse Polish Notation.
    // Evaluate the expression. Return an integer that represents the value of the expression.
    //
    // Note that:
    //
    // - The valid operators are '+', '-', '*', and '/'.
    // - Each operand may be an integer or another expression.
    // - The division between two integers always truncates toward zero.
    // - There will not be any division by zero.
    // - The input represents a valid arithmetic expression in a reverse polish notation.
    // - The answer and all the intermediate calculations can be represented in a 32-bit integer.

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("invalid argument");
        }

        if (tokens.length == 1) return Integer.parseInt(tokens[0]);

        Deque<Integer> stack = new ArrayDeque<>(tokens.length / 2 + 1);

        for (String token : tokens) {
            int number = switch (token) {
                case "+" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    yield a + b;
                }
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    yield a - b;
                }
                 case "*" -> {
                     int b = stack.pop();
                     int a = stack.pop();
                     yield a * b;
                 }
                 case "/" -> {
                     int b = stack.pop();
                     int a = stack.pop();
                     yield a / b;
                 }
                default -> Integer.parseInt(token);
            };

            stack.push(number);
        }

        return stack.pop();
    }

}
