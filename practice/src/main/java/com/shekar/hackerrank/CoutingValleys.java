package com.shekar.hackerrank;

import java.util.Scanner;

public class CoutingValleys {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String path = scanner.nextLine();

        CoutingValleys coutingValleys = new CoutingValleys();
        System.out.println(coutingValleys.countingValleys(N, path));
    }

    private int countingValleys(int n, String s) {
        int valleyCount = 0;
        int prevPosition = 0;
        int currPosition = 0;

        for (char c : s.toCharArray()) {
            prevPosition = currPosition;
            if (c == 'U') {
                currPosition += 1;
            } else if (c == 'D') {
                currPosition -= 1;
            }

            if (currPosition == 0 && prevPosition == -1) {
                valleyCount++;
            }
        }
        return valleyCount;
    }

}
