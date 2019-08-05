package com.shekar.codesignal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OwnHashMap {


    public static void main(String[] args) {

        String[] queryType = {"insert",
                "insert",
                "addToValue",
                "addToKey",
                "get"};

        int[][] query = {{1,2}, 
 {2,3}, 
 {2}, 
 {1}, 
 {3}};

        System.out.println(hashMap(queryType, query));

    }

    public static long hashMap(String[] queryType, int[][] query) {

        long sumOfGets = 0;

        HashMap<Integer, Integer> actualMap = new HashMap<>();

        int k = 0;
        for (String q : queryType) {
            if (q.equalsIgnoreCase("insert")) {
                int key = query[k][0];
                int value = query[k][1];
                k += 1;
                actualMap.put(key, value);
            } else if (q.equalsIgnoreCase("addToValue")) {
                int value = query[k][0];
                k += 1;

                for(Integer key : actualMap.keySet()) {
                    actualMap.put(key, actualMap.get(key) + value);
                }
            } else if (q.equalsIgnoreCase("addToKey")) {
                int value = query[k][0];
                k += 1;

                HashMap<Integer, Integer> newMap = new HashMap<>();
                Set<Map.Entry<Integer, Integer>> entries = actualMap.entrySet();
                for(Map.Entry<Integer, Integer> entry : entries) {
                    newMap.put(entry.getKey() + value, entry.getValue());
                }
                actualMap = newMap;

            } else if (q.equalsIgnoreCase("get")) {
                int key = query[k][0];
                k += 1;

                int v = actualMap.get(key);
                sumOfGets += (long)v;
            }
        }

        return sumOfGets;
    }
}
