package com.priyakdey.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class WordDistance {

    // https://leetcode.com/problems/shortest-word-distance-ii/

    private final Map<String, List<Integer>> indexMap;

    public WordDistance(String[] wordsDict) {
        this.indexMap = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!this.indexMap.containsKey(word)) {
                indexMap.put(word, new ArrayList<>());
            }
            indexMap.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = indexMap.get(word1);
        List<Integer> indices2 = indexMap.get(word2);

        int curr1 = 0, curr2 = 0;

        int minDistance = Integer.MAX_VALUE;

        while (curr1 < indices1.size() && curr2 < indices2.size()) {
            int distance = Math.abs(indices1.get(curr1) - indices2.get(curr2));
            minDistance = Math.min(minDistance, distance);
            if (indices1.get(curr1) <= indices2.get(curr2)) {
                curr1++;
            } else {
                curr2++;
            }
        }

        while (curr1 < indices1.size()) {
            int distance = Math.abs(indices1.get(curr1) - indices2.getLast());
            minDistance = Math.min(minDistance, distance);
            curr1++;
        }

        while (curr2 < indices2.size()) {
            int distance = Math.abs(indices1.getLast() - indices2.get(curr2));
            minDistance = Math.min(minDistance, distance);
            curr2++;
        }

        return minDistance;
    }

}
