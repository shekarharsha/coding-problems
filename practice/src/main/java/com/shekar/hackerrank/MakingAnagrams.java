package com.shekar.hackerrank;

import java.util.Arrays;

public class MakingAnagrams {

    public static void main(String[] args) {

        System.out.println(solve("abc", "cde"));
        System.out.println(solve("aabbccc", "aabbccce"));
        System.out.println(solve("a", "b"));
        System.out.println(solve("", ""));
        System.out.println(solve("abc", "abc"));
        System.out.println(solve("abc", "cde"));
    }

    public static int solve(String a, String b) {
        int noOfDeletions = 0;

        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] aCharMap = new int[26];
        int[] bCharMap = new int[26];

        Arrays.fill(aCharMap, 0);
        Arrays.fill(bCharMap, 0);

        for (Character c : a.toCharArray()) {
            aCharMap[c - 'a']++;
        }

        for (Character c : b.toCharArray()) {
            bCharMap[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            noOfDeletions += Math.abs(aCharMap[i] - bCharMap[i]);
        }

        return noOfDeletions;
    }


}
