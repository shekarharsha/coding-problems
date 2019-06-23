package com.shekar.hackerrank;

import java.util.Scanner;

public class SockMerchant {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int input[] = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        SockMerchant sockMerchant = new SockMerchant();
        System.out.println(sockMerchant.solveProblem(N, input));
    }

    private int solveProblem(int n, int[] ar) {

        int[] uniques = new int[101];
        int total = 0;

        for (int i : ar) {
            uniques[i]++;
        }

        for (int count : uniques) {
            total += count/2;
        }

        return total;
    }

}
