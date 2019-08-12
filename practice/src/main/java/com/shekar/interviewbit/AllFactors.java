package com.shekar.interviewbit;

import java.util.*;

public class AllFactors {

    public static void main(String[] args) {

        ArrayList<Integer> out = allFactors(1);
        out.stream().forEach(System.out::println);
    }

    public static ArrayList<Integer> allFactors(int A) {

        Set<Integer> out = new TreeSet<>();
        out.add(1);
        out.add(A);

        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                out.add(i);
                out.add(A/i);
            }
        }

        return new ArrayList<>(out);
    }
}
