package com.shekar.interviewbit;

public class MinStepsInfiniteGrid {

    public static void main(String[] args) {

        int[] A = {0, 2, 2};
        int[] B = {0, 2, 3};

        System.out.println(coverPoints(A, B));

    }

    private static int coverPoints(int[] A, int[] B) {

        int minSteps = 0;

        for(int i = 1; i < A.length; i++) {
            int maxDiff = Math.max(Math.abs(A[i] - A[i-1]), Math.abs(B[i] - B[i-1]));
            minSteps += maxDiff;
        }

        return minSteps;
    }

}
