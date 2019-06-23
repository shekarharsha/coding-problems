package com.shekar.hackerrank;

import java.util.Scanner;

public class RepeatedString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        long repetition = sc.nextInt();

        RepeatedString repeatedString = new RepeatedString();
        System.out.println(repeatedString.repeatedString(input, repetition));

        System.out.println(input.substring(0,0));
    }

    private long repeatedString(String s, long n) {

        long totalAs = 0;
        int numberOfAsInBaseString = 0;

        for ( char c : s.toCharArray()) {
            if(c == 'a') {
                numberOfAsInBaseString++;
            }
        }

        long totalRepetitions = n/s.length();
        long subStringLength = n % s.length();

        int numberOfAsInSubString = 0;
        if ( subStringLength != 0) {
            String subString = s.substring(0, (int) subStringLength);

            for (char c : subString.toCharArray()) {
                if (c == 'a') {
                    numberOfAsInSubString++;
                }
            }
        }

        totalAs = (numberOfAsInBaseString * totalRepetitions) + numberOfAsInSubString;
        return totalAs;
    }
}
