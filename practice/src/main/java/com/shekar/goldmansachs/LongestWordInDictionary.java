package com.shekar.goldmansachs;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWordInDictionary {

    public static void main(String[] args) {

        /* Print the longest words possible by rearranging letters
        * that match in the dictionary
        */

        String[] dictionary = {"toe", "to", "toes", "dogs", "gods"};
        solution("ote", dictionary);
        System.out.println("------------");
        solution("sgdos", dictionary);
        System.out.println("------------");
        solution("dog", dictionary);
        System.out.println("------------");
        solution("stoedg", dictionary);
        System.out.println("------------");
    }

    public static void solution(String letters, String[] dictionary) {

        char[] sortLetters = letters.toCharArray();
        Arrays.sort(sortLetters);

        int lengthLongestWord = -1;
        HashSet<String> out = new HashSet<>();

        for (String word : dictionary) {
            if (word.length() <= letters.length()) {
                char[] sortWord = word.toCharArray();
                Arrays.sort(sortWord);

                int longestCommonPrefix = lcp(sortLetters, sortWord);
                if (longestCommonPrefix != -1 && longestCommonPrefix == lengthLongestWord) {
                    out.add(word);
                } else if (longestCommonPrefix > lengthLongestWord) {
                    out = new HashSet<>();
                    out.add(word);
                    lengthLongestWord = longestCommonPrefix;
                }
            }
        }

        out.stream().forEach(System.out::println);
    }

    private static int lcp(char[] a, char[] b) {

        int minLength = Math.min(a.length, b.length);

        for (int i = 0; i < minLength; i++) {
            if (a[i] == b[i]) {
                continue;
            } else {
                return i == 0 ? -1 : i;
            }
        }

        return minLength;
    }

}
