package com.shekar.interviewbit;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4};
        int[] out = wave(A);

        Arrays.stream(out).forEach(System.out::println);

    }


    public static int[] wave(int[] A) {

        Arrays.sort(A);

        for (int i = 0; i < A.length; i+=2) {
            if (i != (A.length - 1)) {
                swap(A, i, i+1);
            }
        }

        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
