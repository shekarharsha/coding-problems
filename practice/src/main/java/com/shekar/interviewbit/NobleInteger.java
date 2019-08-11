package com.shekar.interviewbit;

import java.util.Arrays;
import java.util.Stack;

public class NobleInteger {


    public static void main(String[] args) {

        int[] A = {-4, -3, -1, 1};
        System.out.println(solve(A));

    }

    public static int solve(int[] A) {

        Arrays.sort(A);
        Stack<Integer> stack = new Stack<>();
        //stack.push(A[A.length - 1]);

        if (A[A.length - 1] == 0) {
            return 1;
        }

        for (int i = A.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || A[i] == stack.peek()) {
                stack.push(A[i]);
            } else {
                if (A[i] == stack.size()) {
                    return 1;
                } else {
                    stack.push(A[i]);
                }
            }
        }

        return -1;
    }
}
