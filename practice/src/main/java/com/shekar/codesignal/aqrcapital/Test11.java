package com.shekar.codesignal.aqrcapital;

public class Test11 {

    public static void main(String[] args) {



    }

    public static long arrayTrip(int[] arr, int k) {
        long maxSum = 0;
        long currMax = 0;

        int i = 0;
        while (i != (arr.length -1)) {
            int jump = 0;
            int curJump = 0;
            for (jump = 1; jump <= k && (i + jump) < arr.length; jump++) {

                currMax = Math.max(currMax, currMax + arr[i+jump]);
            }

        }

        return maxSum;
    }
}
