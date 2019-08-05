package com.shekar.codesignal;

import java.util.HashMap;

public class MergeStrings {

    public static void main(String[] args) {

        String s1 = "fpniswlxslcjgaau";
        String s2 = "txwqqryebhjrjwkgx";

        System.out.println(mergeStrings(s1, s2));

    }

    public static String mergeStrings(String s1, String s2) {

        StringBuilder mergedString = new StringBuilder();

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        storeOccurences(s1Map, s1);
        storeOccurences(s2Map, s2);

        int i = 0, j = 0;

        while(i < s1.length() && j < s2.length()) {
            if (s1Map.get(s1.charAt(i)) == s2Map.get(s2.charAt(j))) {
                if (s1.charAt(i) <= s2.charAt(j)) {
                    mergedString.append(s1.charAt(i++));
                } else {
                    mergedString.append(s2.charAt(j++));
                }
            } else if (s1Map.get(s1.charAt(i)) < s2Map.get(s2.charAt(j))) {
                mergedString.append(s1.charAt(i++));
            } else {
                mergedString.append(s2.charAt(j++));
            }
        }

        if (i == s1.length()) {
            while (j < s2.length()) {
                mergedString.append(s2.charAt(j++));
            }
        }

        if (j == s2.length()) {
            while (i < s1.length()) {
                mergedString.append(s1.charAt(i++));
            }
        }

        return mergedString.toString();
    }

    private static void storeOccurences(HashMap<Character, Integer> countMap, String s) {

        for (Character c : s.toCharArray()) {
            int count = countMap.getOrDefault(c, 0);
            countMap.put(c, ++count);
        }

    }
}
