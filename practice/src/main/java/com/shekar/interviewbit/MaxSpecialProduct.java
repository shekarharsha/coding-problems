package com.shekar.interviewbit;

import java.util.Arrays;
import java.util.Stack;

public class MaxSpecialProduct {

    public static void main(String[] args) {

        int[] A = {5,9,6,8,6,4,6,9,5,4,9};
        System.out.println(maxSpecialProduct(A));
    }

    public static int maxSpecialProduct(int[] A) {

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        int[] left = new int[A.length];
        int[] right = new int[A.length];

        long maxProd = 0;

        Arrays.fill(left, 0);
        Arrays.fill(right, 0);

        leftStack.push(0);
        rightStack.push(A.length -1);

        for (int i = 1; i < A.length-1; i++) {
            left[i] = getNearestMaxPositions(leftStack, A, i);
            right[A.length - 1 - i] = getNearestMaxPositions(rightStack, A, A.length - 1 - i);
        }

        for (int i = 0; i < A.length; i++) {
            if ((((long)left[i] * (long)right[i]) % 1000000007) > maxProd) {
                maxProd = (((long)left[i] * (long)right[i]) % 1000000007);
            }
        }

        return (int)maxProd;

    }

    private static int getNearestMaxPositions(Stack<Integer> stack, int[] arr, int curPos) {

        int maxPos = stack.peek();
        while (arr[curPos] >= arr[maxPos]) {
            stack.pop();
            if(stack.isEmpty()) {
                maxPos = 0;
                break;
            } else {
                maxPos = stack.peek();
            }
        }
        stack.push(curPos);
        return maxPos;
    }


}
