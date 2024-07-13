package com.priyakdey.stack;

/**
 * @author Priyak Dey
 * @since 13-07-2024
 */
public class BestDigits {

    // Write a function that takes a positive integer represented as a string number and an
    // integer numDigits. Remove numDigits from the string so that the number represented by the
    // string is as large as possible afterwards.
    // Note that the order of the remaining digits cannot be changed. You can assume numDigits
    // will always be less than the length of number and greater than or equal to 0.

    public String bestDigits(String number, int numDigits) {
        if (number == null || number.isEmpty() || numDigits < 0 || numDigits > number.length()) {
            throw new IllegalArgumentException("invalid argument");
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : number.toCharArray()) {
            while (!sb.isEmpty() && sb.charAt(sb.length() - 1) <= ch && numDigits > 0) {
                sb.deleteCharAt(sb.length() - 1);
                numDigits--;
            }
            sb.append(ch);
        }

        while (numDigits > 0) {
            sb.deleteCharAt(sb.length() - 1);
            numDigits--;
        }

        return sb.toString();
    }

}
