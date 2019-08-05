package com.shekar.hackerrank;

import java.util.HashSet;

public class TwoStrings {

    public static void main(String[] args) {

    }

    public static String twoStrings(String s1, String s2) {

        String out = "NO";
        HashSet<Character> str1 = new HashSet<>();
        for(Character c : s1.toCharArray()) {
            str1.add(c);
        }

        for (Character c : s2.toCharArray()) {
            if (str1.contains(c)) {
                out = "YES";
                break;
            }
        }

        return out;
    }
}
