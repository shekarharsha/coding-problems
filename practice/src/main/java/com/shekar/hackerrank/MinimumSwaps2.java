package com.shekar.hackerrank;

import java.util.Scanner;

public class MinimumSwaps2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] splitLine = sc.nextLine().split(" ");

        int[] in = new int[splitLine.length];
        for (int i = 0; i < splitLine.length; i++) {
            in[i] = Integer.parseInt(splitLine[i]) - 1;
        }

        MinimumSwaps2 minimumSwaps2 = new MinimumSwaps2();
        System.out.println(minimumSwaps2.minimumSwaps(in));


    }

    private int minimumSwaps(int[] arr) {
        int minSwaps = 0;
        int i = 0;

        while(i < arr.length) {
            if (arr[i] != i) {
                minSwaps++;
                swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }

        return minSwaps;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
