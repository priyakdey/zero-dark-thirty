package com.priyakdey;

public class RansomNote {

    // https://leetcode.com/problems/ransom-note/description/

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] countArr = new int[26];

        for (char ch : magazine.toCharArray()) {
            int index = ch - 'a';
            countArr[index]++;
        }

        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            if (countArr[index] == 0) {
                return false;
            }
            countArr[index]--;
        }

        return true;
    }
}
