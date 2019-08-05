package com.shekar.codesignal.aqrcapital;


import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

public class Test3 {

    public static void main(String[] args) {

        System.out.println(rearrangeTheSentence("Hi h h."));


    }

    private static String rearrangeTheSentence(String sentence) {

        TreeMap<Integer, ArrayList<String>> lengthBasedWordsMap = new TreeMap<>();
        //StringBuilder sb = null;
        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");

        for (String word : words) {
            if (word.contains(".")) {
                word = word.substring(0, word.indexOf("."));
            }
            Integer length = word.length();
            ArrayList<String> list = lengthBasedWordsMap.getOrDefault(length, new ArrayList<>());
            list.add(word.toLowerCase());
            lengthBasedWordsMap.put(length, list);
        }

        ArrayList<String> list = lengthBasedWordsMap.get(lengthBasedWordsMap.firstKey());
        String firstWord = list.get(0);
        firstWord = firstWord.replace(firstWord.charAt(0), Character.toUpperCase(firstWord.charAt(0)));
        list.set(0, firstWord);
        lengthBasedWordsMap.put(lengthBasedWordsMap.firstKey(), list);

        /* for (Integer length : lengthBasedWordsMap.keySet()) {
            ArrayList<String> lengthBasedWords = lengthBasedWordsMap.get(length);
            for (int i = 0; i < lengthBasedWords.size(); i++) {
                sb.append(lengthBasedWords.get(i));
                sb.append(" ");
            }
        } */

        Collection<ArrayList<String>> values = lengthBasedWordsMap.values();
        for (ArrayList<String> listOfWords : values) {
            for (String word : listOfWords) {
                sb.append(word);
                sb.append(" ");
            }
        }



        /* for (Integer length : lengthBasedWordsMap.keySet()) {

            ArrayList<String> lengthBasedWords = lengthBasedWordsMap.get(length);

            if (sb == null) {
                String firstWord = lengthBasedWords.get(0);
                firstWord = firstWord.replace(firstWord.charAt(0), Character.toUpperCase(firstWord.charAt(0)));
                sb = new StringBuilder(firstWord);
                for (int i = 1; i < lengthBasedWords.size(); i++) {
                    sb.append(" ");
                    sb.append(lengthBasedWords.get(i));
                }
                continue;
            }

            for (int i = 0; i < lengthBasedWords.size(); i++) {
                sb.append(" ");
                sb.append(lengthBasedWords.get(i));
            }
        } */

        //sb.append(".");

        String finalOut = sb.toString();
        finalOut = finalOut.substring(0, finalOut.length()-1);

        return finalOut + ".";

    }
}
