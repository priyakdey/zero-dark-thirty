package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 * @since 10-07-2024
 */
public class BasicCalculator {

    // Given a string s representing a valid expression, implement a basic calculator to evaluate
    // it, and return the result of the evaluation.
    //
    // Note: You are not allowed to use any built-in function which evaluates strings as
    // mathematical expressions, such as eval().
    //
    // - 1 <= s.length <= 3 * 105
    // - s consists of digits, '+', '-', '(', ')', and ' '.
    // - s represents a valid expression.
    // - '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
    // - '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
    // - There will be no two consecutive operators in the input.
    // - Every number and running calculation will fit in a signed 32-bit integer.

    // TODO: Immediate evaluation while parsing

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid argument");
        }

        int radix = 10;
        if (s.length() == 1) {
            return Integer.parseInt(s, radix);
        }

        List<String> tokens = tokenize(s);

        Deque<String> stack = new ArrayDeque<>();

        int a, b, c;
        String op;

        for (String token : tokens) {
            switch (token) {
                case "(":
                    stack.push(token);
                    break;
                case "+", "-":
                    if (stack.isEmpty() || Objects.equals(stack.peek(), "(")) {
                        stack.push("0");
                    }
                    stack.push(token);
                    break;
                case ")":
                    b = Integer.parseInt(stack.pop(), radix);
                    stack.pop(); // pop the opening pair
                    if (stack.isEmpty() || Objects.equals(stack.peek(), "(")) {
                        stack.push(Integer.toString(b));
                    } else {
                        op = stack.pop();
                        a = Integer.parseInt(stack.pop(), radix);
                        c = switch (op) {
                            case "+" -> a + b;
                            case "-" -> a - b;
                            default -> throw new IllegalArgumentException();
                        };
                        stack.push(Integer.toString(c));
                    }
                    break;
                default:
                    if (stack.isEmpty() || Objects.equals(stack.peek(), "(")) {
                        stack.push(token);
                    } else {
                        b = Integer.parseInt(token, radix);
                        op = stack.pop();
                        a = Integer.parseInt(stack.pop(), radix);
                        c = switch (op) {
                            case "+" -> a + b;
                            case "-" -> a - b;
                            default -> throw new IllegalArgumentException("invalid expression");
                        };
                        stack.push(Integer.toString(c));
                    }
            }
        }

        return Integer.parseInt(stack.pop());
    }


    private List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();

        boolean isNumber = false;
        int number = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= 48 && ch <= 57) {
                number = number * 10 + (ch - 48);
                isNumber = true;
            } else {
                if (isNumber) {
                    tokens.add(Integer.toString(number));
                    number = 0;
                    isNumber = false;
                }

                if (ch != ' ') {
                    tokens.add(String.valueOf(ch));
                }
            }
        }

        if (isNumber) {
            tokens.add(Integer.toString(number));
        }

        return tokens;
    }
}