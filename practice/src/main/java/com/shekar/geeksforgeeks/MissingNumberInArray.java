package com.shekar.geeksforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MissingNumberInArray {

    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());

                int totalSum = (N * (N + 1)) / 2;

                int partialSum = 0;

                String numbers = br.readLine();
                String[] numberArr = numbers.split(" ");
                for (int i = 0; i < N - 1; i++) {
                    partialSum += Integer.parseInt(numberArr[i]);
                }

                System.out.println(totalSum - partialSum);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
