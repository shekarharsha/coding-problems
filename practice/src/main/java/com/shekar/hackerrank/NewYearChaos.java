package com.shekar.hackerrank;

import java.util.Scanner;

public class NewYearChaos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int N = sc.nextInt();

            int[] in = new int[N];

            for(int i = 0; i < N; i++) {
                in[i] = sc.nextInt();
            }

            NewYearChaos newYearChaos = new NewYearChaos();
            newYearChaos.minimumBribes(in);
        }


    }

    private void minimumBribes(int[] q) {

        for (int i = 0; i < q.length; i++) {
            if ((i+1) - q[i] < -2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int minBribes = 0;

        for (int i = 0; i < q.length; i++) {
            for (int j = i+1; j < q.length; j++) {
                if (q[j] < q[i]) {
                    minBribes++;
                } else {
                    break;
                }
            }
        }

        System.out.println(minBribes);

    }
}
