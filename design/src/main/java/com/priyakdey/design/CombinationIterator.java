package com.priyakdey.design;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    private final List<String> combinations;
    private int cursor;

    public CombinationIterator(String characters, int combinationLength) {
        this.combinations = new ArrayList<>();
        generateCombinations(characters, 0, combinationLength,
                new StringBuilder(), combinations);
        this.cursor = 0;
    }


    public String next() {
        return combinations.get(cursor++);
    }

    public boolean hasNext() {
        return cursor < combinations.size();
    }

    private void generateCombinations(String characters,
                                      int index,
                                      int combinationLength,
                                      StringBuilder buf,
                                      List<String> combinations) {
        if (buf.length() == combinationLength) {
            combinations.add(buf.toString());
            return;
        }

        if (index == characters.length()) {
            return;
        }

        buf.append(characters.charAt(index));
        generateCombinations(characters, index + 1, combinationLength, buf,
                combinations);
        buf.deleteCharAt(buf.length() - 1);

        generateCombinations(characters, index + 1, combinationLength, buf,
                combinations);
    }

}