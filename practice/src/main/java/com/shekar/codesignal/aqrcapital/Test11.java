package com.shekar.codesignal.aqrcapital;

import java.util.Arrays;

public class Test11 {

    public static void main(String[] args) {

        int[] in = {-2, -3, 5, -4, -2, 3};

        System.out.println(arrayTrip(in, 3));

    }

    public static long arrayTrip(int[] arr, int k) {

        long[] maxSum = new long[arr.length];
        Arrays.fill(maxSum, Long.MIN_VALUE);
        maxSum[0] = arr[0];
        int N = arr.length;

        for(int i = 0; i < N; i++) {
            for (int j = i+1; j <= i+k && j < N; j++) {
                maxSum[j] = Math.max(maxSum[j], maxSum[i] + (long)arr[j]);
            }
        }

        return maxSum[arr.length - 1];
    }
}
