package com.shekar.interviewbit;

import java.util.*;

public class Anagrams {


    public static void main(String[] args) {

        List<String> A = new ArrayList<>(Arrays.asList("mad", "dog", "cat", "god", "tca"));

        ArrayList<ArrayList<Integer>> out = anagrams(A);

        out.stream().forEach(System.out::println);

    }

    /*public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

        boolean[] anagramIncluded = new boolean[A.size()];
        Arrays.fill(anagramIncluded, false);

        ArrayList<ArrayList<Integer>> out = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {
                if (!anagramIncluded[i] && !anagramIncluded[j]) {
                    if (isAnagram(A.get(i), A.get(j))) {

                        ArrayList<Integer> anagramPair = new ArrayList<>();
                        anagramPair.add(i+1);
                        anagramPair.add(j+1);
                        out.add(anagramPair);

                        anagramIncluded[i] = anagramIncluded[j] = true;
                    }
                }
            }
        }

        return out;
    }

    private static boolean isAnagram(String one, String two) {

        int[] hash = new int[26];
        Arrays.fill(hash, 0);

        for (char c : one.toLowerCase().toCharArray()) {
            hash[c - 'a'] += 1;
        }

        for (char c : two.toLowerCase().toCharArray()) {
            hash[c - 'a'] -= 1;
        }

        boolean b = Arrays.stream(hash).allMatch(value -> value == 0);

        return b;
    }*/

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int j = 0;

        for (int i = 0; i < A.size(); i++) {
            char[] charArray = A.get(i).toCharArray();
            Arrays.sort(charArray);
            String chars = new String(charArray);

            if (map.containsKey(chars)) {
                ArrayList<Integer> pair = out.get(map.get(chars));
                pair.add(i+1);
            } else {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i+1);
                out.add(j, pair);
                map.put(chars, j++);
            }
        }

        return out;
    }
}
