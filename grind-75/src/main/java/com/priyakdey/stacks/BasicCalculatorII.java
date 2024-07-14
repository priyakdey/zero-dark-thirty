package com.priyakdey.stacks;

import java.util.*;

/**
 * @author Priyak Dey
 * @since 09-07-2024
 */
public class BasicCalculatorII {

    // Given a string s which represents an expression, evaluate this expression and return its
    // value.
    // The integer division should truncate toward zero.
    // You may assume that the given expression is always valid. All intermediate results will be
    // in the range of [-231, 231 - 1].
    // Note: You are not allowed to use any built-in function which evaluates strings as
    // mathematical expressions, such as eval().

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        if (s.length() == 1) return Integer.parseInt(s);

        List<String> tokens = tokenize(s);
        Set<String> validOperators = Set.of("+", "-", "*", "/");

        Deque<Integer> operands = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();

        for (String token : tokens) {
            if (validOperators.contains(token)) {
                operators.push(token);
            } else {
                int number = Integer.parseInt(token);
                if (!operators.isEmpty()) {
                    String op = operators.peek();
                    number = switch (op) {
                        case "+", "-" -> number;
                        case "*" -> {
                            operators.pop();
                            yield operands.pop() * number;
                        }
                        case "/" -> {
                            operators.pop();
                            yield operands.pop() / number;
                        }
                        default -> throw new IllegalArgumentException("invalid argument");
                    };
                }
                operands.push(number);
            }
        }

        while (!operators.isEmpty()) {
            String op = operators.pollLast();
            int a = operands.pollLast();
            int b = operands.pollLast();
            if (Objects.equals(op, "+")) {
                operands.offerLast(a + b);
            } else {
                operands.offerLast(a - b);
            }
        }

        return operands.pop();
    }

    private List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        int number = 0;

        for (char ch : s.toCharArray()) {
            if (ch >= 48 && ch <= 57) {
                number = number * 10 + (ch - 48);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                tokens.add(Integer.toString(number, 10));
                number = 0;
                tokens.add(Character.toString(ch));
            }
        }
        tokens.add(Integer.toString(number, 10));
        return tokens;
    }

}
