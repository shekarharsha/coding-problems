package com.shekar.hackerrank;

import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();

        int[] inp = new int[n];

        for(int i = 0; i < n; i++) {
            inp[i] = sc.nextInt();
        }

        LeftRotation leftRotation = new LeftRotation();
        int[] out = leftRotation.rotLeft(inp, d);

        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }
    }

    private int[] rotLeft(int[] a, int d) {
        int[] out = new int[a.length];

        /* for ( int i = d; i < a.length; i++) {
            out[j++] = a[i];
        }

        for (int i = 0; i < d; i++) {
            out[j++] = a[i];
        } */

        for (int i = 0; i < a.length; i++) {
            int j = (i + (a.length - d)) % a.length;
            out[j] = a[i];
        }

        return out;
    }

}
