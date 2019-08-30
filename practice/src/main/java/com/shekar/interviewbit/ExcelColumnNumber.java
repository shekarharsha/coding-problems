package com.shekar.interviewbit;

public class ExcelColumnNumber {

    public static void main(String[] args) {

        System.out.println(titleToNumber("AA"));
    }

    public static int titleToNumber(String A) {

        int out = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            out += (A.charAt(i) - 'A' + 1) * (int)Math.pow((double)26, (double)(A.length() - 1 - i));
        }

        return out;
    }
}
