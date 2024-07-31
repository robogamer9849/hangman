package com.example.demo1;

import java.util.HashSet;

public class counter {

    private int uniqueChars = 0;
    private boolean[] charFound = new boolean[26]; // Assuming all characters are lowercase a-z

    public int countUniqueChars(String word) {
        int uniqueChars = 0;
        boolean[] charFound = new boolean[26];

        for (char c : word.toLowerCase().toCharArray()) {
            // Check for lowercase letters only
            if (c >= 'a' && c <= 'z') {
                int index = c - 'a';
                if (!charFound[index]) {
                    uniqueChars++;
                    charFound[index] = true;
                }
            }
        }
        return uniqueChars;
    }

}

