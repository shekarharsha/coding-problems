package com.shekar.hackerrank;

import java.util.HashMap;

public class RansomNote {

    public static void main(String[] args) {

        String[] magazine = {"Do", "do", "you", "YOU"};
        String[] note = {"Do", "you"};

        checkMagazine(magazine, note);

    }

    public static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> mag = new HashMap<>();
        for (String word : magazine) {
            mag.put(word, mag.getOrDefault(word, 0)+1);
        }

        for(String word : note) {
            if (mag.containsKey(word) && mag.get(word) >= 1) {
                mag.put(word, mag.get(word)-1);
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }
}
