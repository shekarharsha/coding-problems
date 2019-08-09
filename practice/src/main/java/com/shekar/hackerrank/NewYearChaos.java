package com.shekar.hackerrank;

import java.util.Scanner;

public class NewYearChaos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] inp = new int[n];

            for (int i = 0; i < n; i++) {
                inp[i] = sc.nextInt();
            }

            NewYearChaos newYearChaos = new NewYearChaos();
            newYearChaos.solution(inp);
        }


    }

    private void solution(int[] q) {

        int totalBribes = 0;

        for(int i = 0; i < q.length; i++) {

            if ((i+1) - q[i] < -2) {
                System.out.println("Too chaotic");
                return;
            }

            for(int j = i; j < q.length; j++) {

                if (q[i] > q[j]) {
                    totalBribes++;
                }
            }
        }

        System.out.println(totalBribes);
    }
}
