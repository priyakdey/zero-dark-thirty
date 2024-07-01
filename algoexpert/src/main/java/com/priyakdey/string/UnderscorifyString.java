package com.priyakdey.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 * @since 01-07-2024
 */
public class UnderscorifyString {

    // Write a function that takes in two strings: a main string and a potential substring of the
    // main string. The function should return a version of the main string with every instance
    // of the substring in it wrapped between underscores.
    // If two or more instances of the substring in the main string overlap each other or sit
    // side by side, the underscores relevant to these substrings should only appear on the far
    // left of the leftmost substring and on the far right of the rightmost substring. If the
    // main string doesn't contain the other string at all, the function should return the main
    // string intact.

    // Find all start, end index of substring in the str and store as 2D array.
    // here I use a O(m*n) approach, for faster algorithms, we should implement KMP/Robin Karp
    // pattern matching algorithms.
    // merge all indices, this takes care of overlapping substrings.
    // now insert underscore in the main string where required.

    public static String underscorifySubstring(String str, String substring) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(substring);

        if (str.isEmpty() || substring.isEmpty()) {
            return str;
        }

        List<Integer[]> indices = matchIndices(str, substring);

        if (indices.isEmpty()) {
            return str;
        }

        int curr = 0;
        int cursor = 0;
        StringBuilder buf = new StringBuilder();

        int length = str.length();
        while (curr < length) {
            if (cursor < indices.size() && curr == indices.get(cursor)[0]) {
                buf.append('_');
                while (curr < indices.get(cursor)[1]) {
                    buf.append(str.charAt(curr++));
                }
                buf.append('_');
                cursor++;
            } else {
                buf.append(str.charAt(curr++));
            }
        }

        return buf.toString();
    }

    // TODO: KMP algorithm will make this faster - O(m + n) instead of O(nm)
    private static List<Integer[]> matchIndices(String str, String substring) {
        List<Integer[]> indices = new ArrayList<>();

        int len = str.length();
        int substrLen = substring.length();

        for (int i = 0; i < len - substrLen + 1; i++) {
            if (Objects.equals(substring, str.substring(i, i + substrLen))) {
                merge(indices, i, i + substrLen);
            }
        }

        return indices;
    }

    private static void merge(List<Integer[]> indices, int start, int end) {
        if (indices.isEmpty()) {
            indices.add(new Integer[]{start, end});
            return;
        }

        int lastStart = indices.getLast()[0];
        int lastEnd = indices.getLast()[1];

        int _start, _end;

        if (start <= lastEnd) {
            _start = lastStart;
            _end = end;
            indices.removeLast();
        } else {
            _start = start;
            _end = end;
        }

        indices.add(new Integer[]{_start, _end});
    }

}
