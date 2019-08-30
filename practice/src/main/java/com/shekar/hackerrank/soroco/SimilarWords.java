package com.shekar.hackerrank.soroco;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SimilarWords {


    public static void main(String[] args) {

        List<String> sentence1 = new ArrayList<>();
        List<String> sentence2 = new ArrayList<>();

        sentence1.add("amazing");
        sentence1.add("acting");
        sentence1.add("abilities");

        sentence2.add("amazing");
        sentence2.add("theatrics");
        sentence2.add("talent");

        List<List<String>> similarity_matrix = new ArrayList<>();

        List<String> similar1 = new ArrayList<>();
        similar1.add("amazing");
        similar1.add("fine");
        similarity_matrix.add(similar1);

        List<String> similar2 = new ArrayList<>();
        similar2.add("good");
        similar2.add("fine");
        similarity_matrix.add(similar2);

        List<String> similar3 = new ArrayList<>();
        similar3.add("acting");
        similar3.add("theatrics");
        similarity_matrix.add(similar3);

        List<String> similar4 = new ArrayList<>();
        similar4.add("abilities");
        similar4.add("talent");
        similarity_matrix.add(similar4);

        System.out.println(isSimilar(sentence1, sentence2, similarity_matrix));

    }

    public static boolean isSimilar(List<String> sentence_1, List<String> sentence_2, List<List<String>> similarity_matrix)    {
        // Write your code here

        if (sentence_1 == null || sentence_2 == null || similarity_matrix == null) {
            return false;
        }

        if (sentence_1.size() != sentence_2.size()) {
            return false;
        }

        if (sentence_1.size() == 0 && sentence_2.size() == 0) {
            /* Empty sentences are similar */
            return true;
        }

        ArrayList<HashSet<String>> similarWordList = new ArrayList<>();
        HashMap<String, Integer> wordListIndexMap = new HashMap<>();

        for (List<String> similarWords : similarity_matrix) {

            String word1 = similarWords.get(0).toLowerCase();
            String word2 = similarWords.get(1).toLowerCase();
            boolean found = false;

            for (int i = 0; i < similarWordList.size(); i++) {
                if (similarWordList.get(i).contains(word1)
                        || similarWordList.get(i).contains(word2)) {

                    similarWordList.get(i).add(word1);
                    similarWordList.get(i).add(word2);
                    wordListIndexMap.put(word1, i);
                    wordListIndexMap.put(word2, i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                HashSet<String> sameWords = new HashSet<>();
                sameWords.add(word1);
                sameWords.add(word2);
                similarWordList.add(sameWords);
                int index = similarWordList.size() - 1;
                wordListIndexMap.put(word1, index);
                wordListIndexMap.put(word2, index);
            }
        }


        for (int i = 0; i < sentence_1.size(); i++) {

            String word1 = sentence_1.get(i).toLowerCase();
            String word2 = sentence_2.get(i).toLowerCase();

            if (!wordListIndexMap.containsKey(word1)
                    || !wordListIndexMap.containsKey(word2)) {
                return false;
            }

            int index = wordListIndexMap.get(word1);
            HashSet<String> similarWords = similarWordList.get(index);

            if (!similarWords.contains(word2)) {
                return false;
            }
        }

        return true;
    }
}
