package com.shekar.interviewbit;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(112211));
    }

    public static int isPalindrome(int A) {

        if (A < 0) {
            return 0;
        }

        int reverse = 0;
        int copyOfA = A;

        int numOfDigits = 0;
        while (A != 0) {
            A = A/10;
            numOfDigits++;
        }

        A = copyOfA;

        while (A != 0) {
            int digit = A % 10;
            reverse += digit * (int)Math.pow((double)10, (double)(numOfDigits-1));
            A = A/10;
            numOfDigits--;
        }

        if (reverse == copyOfA) {
            return 1;
        }

        return 0;

    }

}
