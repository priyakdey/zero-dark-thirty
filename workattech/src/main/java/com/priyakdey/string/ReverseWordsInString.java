package com.priyakdey.string;

/**
 * @author Priyak Dey
 * @since 24-06-2024
 */
public class ReverseWordsInString {

    // Given a string s, reverse the order of words.
    // A word is a sequence of non-space characters. Words in the string s will have one space
    // between them. There are no leading or trailing spaces.

    String reverseWords(String s) {
        StringBuilder buffer = new StringBuilder();
        StringBuilder buf0 = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isWhitespace(ch)) {
                buffer.append(buf0.reverse());
                buffer.append(" ");
                buf0.setLength(0);
            } else {
                buf0.append(ch);
            }
        }

        if (!buf0.isEmpty()) {
            buffer.append(buf0.reverse());
        }
        return buffer.toString();
    }

}
