package com.priyakdey.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Priyak Dey
 * @since 29-06-2024
 */
public class CommonCharacters {

    // Write a function that takes in a non-empty list of non-empty strings and returns a list of
    // characters that are common to all strings in the list, ignoring multiplicity.
    // Note that the strings are not guaranteed to only contain alphanumeric characters. The list
    // you return can be in any order.


    public String[] commonCharacters(String[] strings) {
        Objects.requireNonNull(strings);
        int length = strings.length;
        if (length == 0) return new String[]{};
        if (length == 1) {
            return strings[0].chars().mapToObj(Character::toString)
                             .collect(Collectors.toCollection(ArrayList::new))
                             .toArray(new String[]{});
        }

        Set<String> common = strings[0].chars().mapToObj(Character::toString)
                                       .collect(Collectors.toSet());

        Set<String> chars = new HashSet<>();

        for (int i = 1; i < length; i++) {
            String word = strings[i];
            word.chars().mapToObj(Character::toString).forEach(chars::add);
            common.removeIf(ch -> !chars.contains(ch));
            chars.clear();
        }

        String[] result = new String[common.size()];
        int curr = 0;
        for (String s : common) {
            result[curr++] = s;
        }

        return result;
    }

    /**
     * Keeps the intersecting elements in the set1.
     * This method mutates the input set1.
     *
     * @param set1 Set
     * @param set2 Set
     */
    private void intersection(Set<Character> set1, Set<Character> set2) {

    }

}
