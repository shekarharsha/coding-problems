package com.shekar.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SherlockAndValidString {

    public static void main(String[] args) {
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid(""));
        System.out.println(isValid("a"));
        System.out.println(isValid("abcdee"));
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aaaabbcc"));
    }

    public static String isValid(String s) {
        String ret = "YES";

        HashMap<Character, Integer> charCount = new HashMap<>();
        HashMap<Integer, Integer> countBuckets = new HashMap<>();

        for (Character c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Integer count : charCount.values()) {
            countBuckets.put(count, countBuckets.getOrDefault(count, 0) + 1);
        }

        if (countBuckets.keySet().size() == 1) {
            ret = "YES";
        }else if (countBuckets.keySet().size() > 2) {
            ret = "NO";
        } else {
            Set<Integer> counts = countBuckets.keySet();

            int prevKey = -1, prevCount = 0;

            for (Integer count : counts) {
                if (prevKey == -1) {
                    prevKey = count;
                    prevCount = countBuckets.get(count);
                    continue;
                }

                if (Math.abs(count - prevKey) > 1) {
                    ret = "NO";
                    break;
                }

                if (prevCount > 1 && countBuckets.get(count) > 1) {
                    ret = "NO";
                    break;
                }
            }

            /*boolean alreadyOneCountMoreThan1 = false;
            for (Integer count : countBuckets.values()) {
                if (count > 1 && alreadyOneCountMoreThan1 == true) {
                    ret = "NO";
                    break;
                } else if (count > 1 && alreadyOneCountMoreThan1 == false) {
                    alreadyOneCountMoreThan1 = true;
                }
            }*/
        }

        return ret;
    }




}
