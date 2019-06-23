package com.shekar.hackerrank;

import java.util.Scanner;

public class TwoDArrayDS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = 6;

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        TwoDArrayDS twoDArrayDS = new TwoDArrayDS();
        System.out.println(twoDArrayDS.hourglassSum(arr));
    }

    private int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int N = 6;

        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < N-2; j++) {
                int currSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                                        arr[i+1][j+1] +
                              arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(currSum >= maxSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;

    }
}
