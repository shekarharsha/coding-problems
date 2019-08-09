package com.shekar.interviewbit;

import java.util.Arrays;
import java.util.Stack;

public class MaxSpecialProduct {

    public static void main(String[] args) {



    }

    public static int maxSpecialProduct(int[] A) {

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        Arrays.fill(left, 0);
        Arrays.fill(right, 0);

        leftStack.push(0);
        rightStack.push(A.length -1);

        for (int i = 1; i < A.length-1; i++) {
            int maxPos = leftStack.peek().intValue();
            if (A[i] > A[maxPos]) {
                leftStack.pop();

            }

        }


    }


}
