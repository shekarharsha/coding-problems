package com.shekar.hackerrank;

public class AlternatingClass {

    public static void main(String[] args) {

        System.out.println(solve("AAABBB"));
        System.out.println(solve("AAAA"));
        System.out.println(solve("ABABABA"));
    }

    public static int solve(String s) {
        int noOfDeletions = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                noOfDeletions++;
            }
        }

        return noOfDeletions;
    }
}
