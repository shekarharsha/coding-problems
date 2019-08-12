package com.shekar.interviewbit;

import java.util.*;

public class LargestNumber {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0, 0);
        System.out.println(largestNumber(list));

    }

    public static String largestNumber(final List<Integer> A) {

        StringBuilder out = new StringBuilder();
        ArrayList<Integer> local = new ArrayList<>(A);

        Collections.sort(local, (o1, o2) -> {

            StringBuilder sb1 = new StringBuilder(String.valueOf(o1));
            sb1.append(o2);

            StringBuilder sb2 = new StringBuilder(String.valueOf(o2));
            sb2.append(o1);

            if(sb1.toString().compareTo(sb2.toString()) > 0) {
                return -1;
            } else {
                return 1;
            }
        });

        for (Integer i : local) {
            out.append(i);
        }

        String outString = out.toString();
        return outString.charAt(0) == '0' ? "0": outString;
    }
}
