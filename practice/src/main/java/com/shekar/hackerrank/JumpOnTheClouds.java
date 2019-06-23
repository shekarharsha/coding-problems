package com.shekar.hackerrank;

import java.util.Scanner;

public class JumpOnTheClouds {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int input[] = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        JumpOnTheClouds jumpOnTheClouds = new JumpOnTheClouds();
        System.out.println(jumpOnTheClouds.jumpingOnClouds(input));
    }

    private int jumpingOnClouds(int[] c) {

        int totalJumps = 0;
        int currPostion = 0;

        while (currPostion != (c.length - 1)) {
            if (currPostion != (c.length - 1) - 1) {
                if (c[currPostion + 2] != 1) {
                    currPostion += 2;
                } else {
                    currPostion += 1;
                }
            } else {
                currPostion += 1;
            }
            totalJumps++;
        }

        return totalJumps;
    }


}
