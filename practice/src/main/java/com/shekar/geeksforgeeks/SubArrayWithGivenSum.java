package com.shekar.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());

            while (T-- > 0) {

                String[] line = br.readLine().split(" ");
                int N = Integer.parseInt(line[0]);
                int S = Integer.parseInt(line[1]);

                line = br.readLine().split(" ");
                long[] inp = new long[N];
                for (int i = 0; i < N; i++) {
                    inp[i] = Long.parseLong(line[i]);
                }

                int head = 0, tail = 0;
                long currSum = inp[head];

                while(currSum != S) {
                    if (currSum < S) {
                        if (tail < (inp.length-1)) {
                            tail += 1;
                        } else {
                            break;
                        }
                        currSum += inp[tail];
                    } else if (currSum > S) {
                        currSum -= inp[head];
                        if (head < (inp.length-1)) {
                            head += 1;
                        } else {
                            break;
                        }
                    }
                }

                if (currSum == S) {
                    System.out.print((head+1) + " " + (tail+1));
                    System.out.println();
                } else {
                    System.out.println(-1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
