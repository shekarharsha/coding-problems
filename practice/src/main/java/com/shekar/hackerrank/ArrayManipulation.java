package com.shekar.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] query = new int[m][3];

        for (int i = 0; i < m; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
            query[i][2] = sc.nextInt();
        }

        ArrayManipulation arrayManipulation = new ArrayManipulation();
        System.out.println(arrayManipulation.result(n, query));

    }

    private long result(int n, int[][] queries) {
        long max = 0;

        long[] out = new long[n+1];
        Arrays.fill(out, 0);

        for (int i = 0; i < queries.length; i++) {
            operation(out, queries[i][0], queries[i][1], queries[i][2]);
        }

        for (int i = 0; i < out.length; i++) {
            if (out[i] > max) {
                max = out[i];
            }
        }

        return max;
    }

    private void operation(long[] out, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            out[i] += value;
        }
    }
}
