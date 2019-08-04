package com.shekar.interviewbit;

import java.util.Arrays;

public class MaxNonNegativeSubArray {

    public static void main(String[] args) {

        //int[] in = {2, 3, 5, -7, 1, 2};
        int[] in = {1967513926, 1540383426, -1303455736, -521595368};

        MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();
        int[] out = maxNonNegativeSubArray.maxset(in);

        Arrays.stream(out).forEach(System.out::println);

    }


    private int[] maxset(int[] A) {
        int best_start = -1, best_end = -1;
        long max_sum = Long.MIN_VALUE;
        int currest_start = 0, current_end = 0;
        long current_sum = 0;


        for (int i = 0; i < A.length; i++) {

            if (A[i] < 0) {
                /*if (current_sum > max_sum) {
                    max_sum = current_sum;
                    best_start = currest_start;
                    best_end = current_end;
                } */
                currest_start = i+1;
                current_sum = 0;
            } else {
                current_sum += A[i];
                current_end = i;
                if (current_sum >= max_sum) {
                    if (current_sum == max_sum) {
                        if ((current_end - currest_start) > (best_end -best_start)) {
                            best_end = current_end;
                            best_start = currest_start;
                        }
                    } else {
                        max_sum = current_sum;
                        best_end = current_end;
                        best_start = currest_start;
                    }
                }
            }
        }

        int[] out = {};
        if (best_start != -1 && best_end != -1) {
            out = Arrays.copyOfRange(A, best_start, best_end + 1);
        }
        return out;
    }
}
