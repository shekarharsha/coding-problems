package com.shekar.interviewbit;


import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestNumber {


    public static void main(String[] args) {

        //int[] A = {4, 5, 2, 10, 8};
        //int[] A = {4, 10, 6};
        int[] A = {4, 20, 15, 10, 8, 10};
        int[] out = prevSmaller(A);

        Arrays.stream(out).forEach(System.out::println);
    }

    public static int[] prevSmaller(int[] A) {


        int[] out = new int[A.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {

            if (stack.isEmpty()) {
                out[i] = -1;
            } else {

                while (!stack.isEmpty() && A[i] <= stack.peek()) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    out[i] = -1;
                } else {
                    out[i] = stack.peek();
                }
            }
            stack.push(A[i]);
        }

        return out;
    }
}

