package com.shekar.codesignal.aqrcapital;

public class Test1 {

    public static void main(String[] args) {

        int[] arr = {0, -3, -2, -5, -7, 1};
        System.out.println(arrayTrip(arr, 3));


    }

    public static long arrayTrip(int[] arr, int k) {

        long maxSum = 0;
        int lastKnownMaxPosition = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i - lastKnownMaxPosition <= k) {
                if ((maxSum + (long)arr[i]) >= maxSum) {
                    maxSum = maxSum + (long)arr[i];
                    lastKnownMaxPosition = i;
                }
            } else {
                maxSum += (long)arr[i];
                lastKnownMaxPosition = i;
            }
        }

        return maxSum;
    }
}
