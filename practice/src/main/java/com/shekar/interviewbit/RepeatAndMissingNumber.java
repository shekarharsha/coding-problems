package com.shekar.interviewbit;

import java.util.Arrays;

public class RepeatAndMissingNumber {


    public static void main(String[] args) {

        int[] a = {3, 1, 2, 5 ,3};
        int[] repeatedAndMissing = repeatedNumber(a);

        Arrays.stream(repeatedAndMissing).forEach(System.out::println);
    }

    private static int[] repeatedNumber(final int[] A) {

        long N = A.length;

        long sumOfNumbers = (N * (N+1))/2;
        long sumOfSqaures = (N * (N+1) * (2*N+1))/6;

        int a = 0, b = 0;

        long actualSumOfNumbers = 0;
        long actualSumOfSqaures = 0;
        for (int i = 0; i < N; i++) {
            actualSumOfNumbers += (long)A[i];
            actualSumOfSqaures += (long)Math.pow(A[i], 2);
        }

        long x = (sumOfSqaures - actualSumOfSqaures)/(sumOfNumbers - actualSumOfNumbers);
        long y = (sumOfNumbers - actualSumOfNumbers);

        a = (int)(x+y)/2;
        b = (int)(x-y)/2;

        int[] out = {b, a};
        return out;
    }
}
