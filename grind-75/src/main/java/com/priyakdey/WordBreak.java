package com.priyakdey;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class WordBreak {

    // Given a string s and a dictionary of strings wordDict, return true if
    // s can be segmented into a space-separated sequence of one or more
    // dictionary words.
    //
    // Note that the same word in the dictionary may be reused multiple times
    // in the segmentation.

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[][] cache = new Boolean[s.length() + 1][s.length() + 1];
        return wordBreak(s, 0, 1, new HashSet<>(wordDict), cache);
    }

    // TODO: try and move this to tabulation

    private boolean wordBreak(String s, int startIndex, int endIndex,
                              Set<String> words, Boolean[][] cache) {
        if (startIndex >= s.length()) {
            return false;
        }

        if (endIndex == s.length()) {
            String word = s.substring(startIndex, endIndex);
            return words.contains(word);
        }

        if (cache[startIndex][endIndex] != null) {
            return cache[startIndex][endIndex];
        }

        // do not partition at this index
        boolean canBreak = wordBreak(s, startIndex, endIndex + 1, words, cache);

        String word = s.substring(startIndex, endIndex);
        if (words.contains(word)) {
            canBreak = canBreak || wordBreak(s, endIndex, endIndex + 1, words
                    , cache);
        }

        cache[startIndex][endIndex] = canBreak;
        return canBreak;
    }

}
